package com.njbailey.irc.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Channel represents an Internet Relay Chat (IRC) chat room on a server.
 */
public class Channel implements MessageTarget {
    private String name;
    private String topic;

    private List<User> connectedUsers = new ArrayList<>();

    /**
     * Construct a new {@code Channel} with the specified name. 
     */
    public Channel(final String name) {
        this.name = name;
        this.topic = "";
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
    }
}