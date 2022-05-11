package com.njbailey.irc.core;

import java.util.Arrays;
import java.util.List;

/**
 * Represents an Message from/to an IRC server.
 */
public class Message {
    private final String prefix;
    private final String command;
    private final List<String> arguments;

    /**
     * Construct a new Message with the specified prefix, command, and arguments.
     * 
     * @param prefix the Message prefix
     * @param command the Message command
     * @param arguments the Message arguments
     */
    public Message(final String prefix, final String command, final String... arguments) {
        this.prefix = prefix;
        this.command = command;
        this.arguments = Arrays.asList(arguments);
    }

    /**
     * Converts the data contained in this Message into a raw {@code String} that could
     * be sent to an IRC server.
     */
    public String toRaw() {
        StringBuilder messageBuilder = new StringBuilder();

        if(prefix != null) {
            messageBuilder.append(":").append(prefix).append(" ");
        }

        messageBuilder.append(command).append(" ");

        for(String argument : arguments) {
            if(argument.chars().anyMatch(Character::isWhitespace)) {
                messageBuilder.append(":").append(argument);
                break;
            } else {
                messageBuilder.append(argument).append(" ");
            }
        }

        return messageBuilder.toString();
    }
}