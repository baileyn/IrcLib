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

    public ChannelPanel(Channel channel) {
        super(new BorderLayout(), channel);

        channel.addUserListener(this);

        super.add(new JScrollPane(chatArea), BorderLayout.CENTER);
        super.add(new JScrollPane(userList), BorderLayout.EAST);
    }

    @Override
    public void userAdded(Channel channel, User user) {
        userList.add(user);
    }

    @Override
    public void userRemoved(Channel channel, User user) {

    }

    public void write(PrivateMessage message) {
        chatArea.writeLine(message.toRaw());
    }
}
