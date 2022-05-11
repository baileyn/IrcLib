package com.njbailey.irc.net;

import com.njbailey.irc.core.Message;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

public class IrcClientHandler extends SimpleChannelInboundHandler<String> {
    private final Network network;

    public IrcClientHandler(final Network network) {
        this.network = network;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        network.setChannel((SocketChannel) ctx.channel());
        network.connected();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        network.destroyChannel();
        network.dropped();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Message message = Message.fromRaw(msg);
        network.messageReceived(message);
    }
}