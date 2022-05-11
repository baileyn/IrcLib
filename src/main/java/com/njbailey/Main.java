package com.njbailey;

import java.util.Arrays;

import com.njbailey.irc.core.Channel;
import com.njbailey.irc.core.Message;
import com.njbailey.irc.core.messages.NumericMessage;
import com.njbailey.irc.core.messages.PrivateMessage;
import com.njbailey.irc.gui.MainFrame;
import com.njbailey.irc.net.Network;
import com.njbailey.irc.net.NetworkHandler;
import com.njbailey.irc.net.event.ConnectionListener;
import com.njbailey.irc.net.event.NumericMessageListener;
import com.njbailey.irc.net.event.PrivateMessageListener;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
   /* public static void main(String[] args) {
        NetworkHandler handler = new NetworkHandler();
        Network network = handler.addNetwork("irc.mozilla.org", 6667);
        network.addConnectionListener(new ConnectionListener(){
            @Override
            public void connectionLost(Network network) {
                // Do nothing.c
            }
        
            @Override
            public void connectionAcquired(Network network) {    
                network.send(Message.createNickMessage("kruptox"));
                network.send(Message.createUserMessage("baileyn", "Nicholas Bailey"));
            }
        });
        network.addNumericMessageListener(new NumericMessageListener() {
            @Override
            public void onNumericMessage(NumericMessage message) {
                if(message.getNumeric() == 5) {
                    network.send(new Message(null, "JOIN", "#ircbots"));
                }
            }
        });
        network.addPrivateMessageListener(new PrivateMessageListener(){
            @Override
            public void onPrivateMessage(PrivateMessage message) {
                String sender = message.getSender();
                String target = message.getTarget();
                String msg = message.getMessage();

                Channel channel = network.getChannel(target);
                System.out.println("[" + target + "][" + sender + "]: " + msg);

                if(msg.equals("!quit")) {
                    System.exit(0); // TODO: Exit gracefully.
                } else if(msg.equals("!talk")) {
                    network.send(new PrivateMessage(target, "Hello, there."));
                } else if(msg.equals("!users")) {
                    if(channel != null) {
                        network.send(new PrivateMessage(target, Arrays.toString(channel.getUsers().toArray())));
                    } else {
                        network.send(new PrivateMessage(target, "Say this in a channel."));
                    }
                } else if(msg.equals("!topic")) {
                    if(channel != null) {
                        network.send(new PrivateMessage(target, channel.getTopic()));
                    } else {
                        network.send(new PrivateMessage(target, "We're not in a channel with a topic."));
                    }
                } else {
                    System.out.println("MESSAGE: \"" + msg + "\"");
                }
            }
        });
    }*/
}