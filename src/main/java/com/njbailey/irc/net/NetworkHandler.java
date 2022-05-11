package com.njbailey.irc.net;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;

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
    
    public ChannelFuture addNetwork(String networkHost, int port) {
        Bootstrap bootstrap = new Bootstrap();
        Network network = new Network(networkHost, port);

        bootstrap.group(eventLoopGroup)
            .channel(NioSocketChannel.class)
            .option(ChannelOption.SO_KEEPALIVE, true)
            .handler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new DelimiterBasedFrameDecoder(MAX_MESSAGE_LENGTH, Delimiters.lineDelimiter()));
                    ch.pipeline().addLast(new StringDecoder());
                    ch.pipeline().addLast(new IrcClientHandler(network));	
				}
            });
        networkList.add(network);
        return network.connect(bootstrap);
    }
}