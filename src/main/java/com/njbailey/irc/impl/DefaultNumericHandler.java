package com.njbailey.irc.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

		switch (message.getNumeric()) {
		case 1:
			if(arguments.size() >= 1) {
				network.createClient(arguments.get(0));
			}
			
			break;
		case 332:
			if (arguments.size() == 3) {
				updateTopic(arguments.get(1), arguments.get(2));
			}
			break;
		case 353:
			if (arguments.size() == 4) {
				System.out.println("updating channel: " + arguments.get(2));
				Channel channel = network.addOrGetChannel(arguments.get(2));
				List<String> names = Arrays.stream(arguments.get(3).split(" ")).collect(Collectors.toList());

				System.out.println("Adding names: " + Arrays.toString(names.toArray()));
				updateNames(channel, names);
			} else {
				System.out.println("Expected NAMES to have 4 arguments, but didn't.");
				System.out.println(message.getCommand() + ": " + Arrays.toString(arguments.toArray()));
			}
			break;
		default:
			System.out.println(
					"Unhandled Numeric: " + message.getNumeric() + ": " + Arrays.toString(arguments.toArray()));
		}
	}

	private void updateTopic(String channelName, String topic) {
		Channel channel = network.addOrGetChannel(channelName);
		channel.setTopic(topic);
	}

	private void updateNames(Channel channel, List<String> names) {
		for (String name : names) {
			channel.addUser(network.addOrGetUser(name));
		}
	}
}