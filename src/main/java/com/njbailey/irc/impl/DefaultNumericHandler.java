package com.njbailey.irc.impl;

import java.util.Arrays;
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
		List<String> arguments = message.getArguments();

		switch(message.getNumeric()) {
			case 332:
				if(arguments.size() == 3) {
					updateTopic(arguments.get(1), arguments.get(2));
				}
				break;
			case 353:
				if(arguments.size() == 4) {
					String names = arguments.get(arguments.size() - 1);

					Channel channel = network.addOrGetChannel(arguments.get(2));
					for(String name : names.split(" ")) {
						name = name.replaceAll("[@+]", "");
						channel.addUser(network.addOrGetUser(name));
					}
				} else {
					System.out.println("Expected NAMES to have 4 arguments, but didn't.");
					System.out.println(message.getCommand() + ": " + Arrays.toString(arguments.toArray()));
				}
				break;
			default:
				System.out.println("Unhandled Numeric: " + message.getNumeric() + ": " + Arrays.toString(arguments.toArray()));
		}
	}

	private void updateTopic(String channelName, String topic) {
		Channel channel = network.addOrGetChannel(channelName);
		channel.setTopic(topic);
	}
}