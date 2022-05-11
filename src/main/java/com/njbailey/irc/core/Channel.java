package com.njbailey.irc.core;

import com.njbailey.irc.event.UserListener;
import com.njbailey.irc.net.Network;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Channel represents an Internet Relay Chat (IRC) chat room on a server.
 */
public class Channel implements MessageTarget {
    private Network network;
    private String name;
    private String topic;

    private List<User> connectedUsers = new ArrayList<>();
    private List<UserListener> userListeners = new ArrayList<>();

    /**
     * Construct a new {@code Channel} with the specified name. 
     */
    public Channel(final String name) {
        this.name = name;
        this.topic = "";
    }

    /**
     * Sets the network of user connected to the channel.
     * @param Network network of user connected to the channel.
     */
    public void setNetwork(Network network) {
        this.network = network;
    }

    /**
     * Return the network connected to the channel.
     * @return the network connected to the channel.
     */
    public Network getNetwork() {
        return network;
    }

    /**
     * Return the name of this channel.
     * @return the name of this channel
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the topic for this channel.
     * @param topic the new topic for the channel
     */
    public void setTopic(final String topic) {
        this.topic = topic;
    }

    /**
     * Return the topic for this channel.
     * @return the topic for this channel
     */
    public String getTopic() {
        return this.topic;
    }

    /**
     * Add the specified user to this channel.
     * 
     * @param user the user to add to this channel
     */
    public void addUser(User user) {
        this.connectedUsers.add(user);
        userListeners.forEach(listener -> listener.userAdded(this, user));
    }

    /**
     * Remove the specified user to this channel.
     *
     * @param user the user to remove from this channel
     */
    public void removeUser(User user) {
        this.connectedUsers.remove(user);
        userListeners.forEach(listener -> listener.userRemoved(this, user));
    }

    /**
     * Return a list of users connected to the channel.
     * @return a list of users connected to the channel
     */
    public List<User> getUsers() {
        return Collections.unmodifiableList(connectedUsers);
    }

    /**
     * Adds the specified {@code UserListener} to the {@code Channel}
     * @param listener the {@code UserListener} to add
     */
    public void addUserListener(UserListener listener) {
        this.userListeners.add(listener);
    }

    /**
     * Removes the specified {@code UserListener} from the {@code Channel}
     * @param listener the {@code UserListener} to remove
     */
    public void removeUserListener(UserListener listener) {
        this.userListeners.remove(listener);
    }
}