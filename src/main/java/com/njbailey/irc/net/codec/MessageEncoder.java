package com.njbailey.irc.net.codec;

import com.njbailey.irc.core.Message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;

public class MessageEncoder extends MessageToByteEncoder<Message> {
	@Override
	protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
        System.out.println("Sending: \"" + msg.toRaw() +"\"");
        out.writeCharSequence(msg.toRaw(), Charset.defaultCharset());
        out.writeChar('\r');
        out.writeChar('\n');
	}
}