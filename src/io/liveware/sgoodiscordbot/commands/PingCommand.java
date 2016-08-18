package io.liveware.sgoodiscordbot.commands;

import io.liveware.sgoodiscordbot.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

/**
 * Created by ChepelevAG on 18.08.2016.
 */
public class PingCommand implements Command {

    private final String HELP = "Usage: ~!ping";

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("Pong");
    }

    @Override
    public String help() {
        return help();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        return;
    }
}
