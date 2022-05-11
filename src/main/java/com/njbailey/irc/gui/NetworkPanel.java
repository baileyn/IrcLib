package com.njbailey.irc.gui;

import com.njbailey.irc.core.Channel;
import com.njbailey.irc.core.Message;
import com.njbailey.irc.core.MessageTarget;
import com.njbailey.irc.core.messages.PrivateMessage;
import com.njbailey.irc.event.ChannelConnectionListener;
import com.njbailey.irc.net.Network;

import javax.swing.*;
import java.awt.*;

public class NetworkPanel extends ClientPanel<Network> implements ChannelConnectionListener {
    private MainFrame mainFrame;
    private ChatArea chatArea;
    private Network network;

    public NetworkPanel(MainFrame mainFrame, Network network) {
        super(new BorderLayout(), network);
        this.chatArea = new ChatArea();
        this.mainFrame = mainFrame;
        this.network = network;

        this.add(new JScrollPane(chatArea), BorderLayout.CENTER);

        network.addChannelConnectionListener(this);
        network.addMessageListener(this::write);
        network.addPrivateMessageListener(this::writeMessage);
    }

    public void write(Message message) {
        chatArea.writeLine(message.toRaw());
    }

    public void writeMessage(PrivateMessage message) {
        ClientPanel<?> panel = mainFrame.getPanel(p -> {
            if (p.getTarget() instanceof MessageTarget) {
                MessageTarget target = (MessageTarget) p.getTarget();

                if (target.getName().equalsIgnoreCase(message.getTarget())) {
                    return true;
                }
            }

            return false;
        });

        if (panel != null) {
            if (panel instanceof NetworkPanel) {
                write(message);
            } else if (panel instanceof ChannelPanel) {
                ((ChannelPanel) panel).write(message);
            }
        }
    }

    @Override
    public void joined(Channel channel) {
        channel.setNetwork(network);
        mainFrame.addPanel(new ChannelPanel(channel));
    }

    @Override
    public void left(Channel channel) {

    }
}
