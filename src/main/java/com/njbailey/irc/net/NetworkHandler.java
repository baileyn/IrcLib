package com.njbailey.irc.net;

import java.util.ArrayList;
import java.util.List;

import com.njbailey.irc.net.codec.MessageEncoder;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Handles all of the networks that we're currently connected to.
 */
public class NetworkHandler {
    private static final int MAX_MESSAGE_LENGTH = 512;
    private EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

    /**
     * A list of currently connected networks.
     */
    private List<Network> networkList = new ArrayList<>();

    /**
     * Add the specified Network to the handler.
     * 
     * @return the Network that was created.
     */
    public Network addNetwork(String networkHost, int port) {
        Bootstrap bootstrap = new Bootstrap();
        Network network = new Network(networkHost, port);

        bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new LineBasedFrameDecoder(MAX_MESSAGE_LENGTH));
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new IrcClientHandler(network));
                        ch.pipeline().addLast(new MessageEncoder());
                    }
                }).connect(networkHost, port);

        networkList.add(network);
        return network;
    }
}