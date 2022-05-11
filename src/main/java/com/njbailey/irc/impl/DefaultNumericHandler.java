package com.njbailey.irc.impl;

import java.util.List;

import com.njbailey.irc.core.Channel;
import com.njbailey.irc.core.messages.NumericMessage;
import com.njbailey.irc.net.Network;
import com.njbailey.irc.net.event.NumericMessageListener;

public class DefaultNumericHandler implements NumericMessageListener {
	private final Network network;

	public DefaultNumericHandler(final Network network) {
		this.network = network;
	}

	@Override
	public void onNumericMessage(NumericMessage message) {
		switch(message.getNumeric()) {
			case 332:
				List<String> arguments = message.getArguments();

				if(arguments.size() == 2) {
					updateTopic(arguments.get(0), arguments.get(1));
				}

				break;
		}
	}

	private void updateTopic(String channelName, String topic) {
		Channel channel = network.addOrGetChannel(channelName);
		channel.setTopic(topic);
	}
}