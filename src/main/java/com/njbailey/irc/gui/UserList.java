package com.njbailey.irc.gui;

import com.njbailey.irc.core.User;

import javax.swing.*;

public class UserList extends JList<User> {
    private DefaultListModel<User> userListModel = new DefaultListModel<>();

    public UserList() {
        super.setModel(userListModel);
    }

    /**
     * Add the specified {@code User} to the {@code UserList}.
     * @param user the {@code User} to add
     */
    public void add(User user) {
        userListModel.addElement(user);
    }
}
