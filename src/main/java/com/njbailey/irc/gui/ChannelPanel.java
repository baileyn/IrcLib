package com.njbailey.irc.gui;

import com.njbailey.irc.core.Channel;
import com.njbailey.irc.core.User;
import com.njbailey.irc.core.messages.PrivateMessage;
import com.njbailey.irc.event.UserListener;

import javax.swing.*;
import java.awt.*;

public class ChannelPanel extends ClientPanel<Channel> implements UserListener {
    private ChatArea chatArea = new ChatArea();
    private UserList userList = new UserList();
    private JSplitPane splitPane = new JSplitPane();

    public ChannelPanel(Channel channel) {
        super(new BorderLayout(), channel);

        channel.addUserListener(this);

        splitPane.setResizeWeight(1);
        splitPane.setLeftComponent(new JScrollPane(chatArea));
        splitPane.setRightComponent(new JScrollPane(userList));

        add(splitPane, BorderLayout.CENTER);
    }

    @Override
    public void userAdded(Channel channel, User user) {
        userList.add(user);

        revalidate();
        repaint();
    }

    @Override
    public void userRemoved(Channel channel, User user) {

    }

    public void write(PrivateMessage message) {
        chatArea.writeLine(message.toRaw());
    }
}
