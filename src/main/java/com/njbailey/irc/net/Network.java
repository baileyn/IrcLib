package com.njbailey.irc.net;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;

/**
 * Represents a Network that's connected to by the Internet Relay Chat.
 */
public class Network {
    private final String host;
    private final int port;

    public Network(final String host, final int port) {
        this.host = host;
        this.port = port;
    }

    public ChannelFuture connect(Bootstrap bootstrap) {
        return bootstrap.connect(host, port);
    }
}
