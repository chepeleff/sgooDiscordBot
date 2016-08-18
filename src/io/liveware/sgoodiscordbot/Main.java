package io.liveware.sgoodiscordbot;

import io.liveware.sgoodiscordbot.commands.PingCommand;
import io.liveware.sgoodiscordbot.utils.CommandParser;
import io.liveware.sgoodiscordbot.utils.Sneaky;
import net.dv8tion.jda.JDA;
import net.dv8tion.jda.JDABuilder;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import java.util.HashMap;

/**
 * Created by ChepelevAG on 18.08.2016.
 */
public class Main {

    private static JDA jda;
    public static final CommandParser parser = new CommandParser();

    public static HashMap<String, Command> commands = new HashMap<>();


    public static void main(String[] args) {
        try {
            jda = new JDABuilder().addListener(new BotListener()).setBotToken(Sneaky.DISCORD_TOKEN).buildBlocking();
            jda.setAutoReconnect(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

        commands.put("ping", new PingCommand());
    }

    public static void handleCommand(CommandParser.CommandContainer cmd) {
        if(commands.containsKey(cmd.invoke)) {
            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);

            if (safe) {
                commands.get(cmd.invoke).action(cmd.args, cmd.event);
                commands.get(cmd.invoke).executed(safe, cmd.event);

            } else {
                commands.get(cmd.invoke).executed(safe, cmd.event);
            }
        }
    }
}
