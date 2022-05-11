package com.njbailey.irc.event;

import com.njbailey.irc.core.Channel;

public interface ChannelConnectionListener {
    void joined(Channel channel);
    void left(Channel channel);
}
