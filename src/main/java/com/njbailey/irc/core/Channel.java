package com.njbailey.irc.core;

/**
 * Channel represents an Internet Relay Chat (IRC) chat room on a server.
 */
public class Channel {
    private String name;
    private String topic;

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
}