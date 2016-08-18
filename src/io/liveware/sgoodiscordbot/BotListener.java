package io.liveware.sgoodiscordbot;

import net.dv8tion.jda.events.ReadyEvent;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;

/**
 * Created by ChepelevAG on 18.08.2016.
 */
public class BotListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContent().startsWith(~!) && event.getAuthor().getId() != event.getJDA().getSelfInfo().getId())  {
           Main.handleCommand(Main.parser.parse(event.getMessage().getContent().toLowerCase()))
        }
    }

    @Override
    public void onReady(ReadyEvent event) {
        Main.log("status", "Logged in as: " + event.getJDA().getSelfInfo().getUsername());
    }

}
