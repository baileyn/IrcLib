package com.njbailey.irc.net;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class IrcClientHandler extends SimpleChannelInboundHandler<String> {
    private final Network network;

    public IrcClientHandler(final Network network) {
        this.network = network;
    }

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		System.out.println("Received: " + msg);
	}
}