package com.njbailey.irc.event;

import com.njbailey.irc.core.Channel;

/**
 * ChannelConnectionLister represents a 
 * Listener for connections joining and leaving
 * a channel.
 */
public interface ChannelConnectionListener {
    void joined(Channel channel);

    void left(Channel channel);
}
