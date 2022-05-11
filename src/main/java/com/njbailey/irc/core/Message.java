package com.njbailey.irc.core;

import com.njbailey.irc.core.messages.NumericMessage;
import com.njbailey.irc.core.messages.PrivateMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
     * Return whether or not this Message has a prefix.
     * @return whether or not this Message has a prefix
     */
    public boolean hasPrefix() {
        return prefix != null;
    }

    /**
     * Return the prefix for this Message.
     * @return the prefix for this Message
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Return the command for this Message.
     * @return the command for this Message.
     */
    public String getCommand() {
        return command;
    }

    /**
     * Return the arguments for this Message.
     * @return the arguments for this message.
     */
    public List<String> getArguments() {
        return Collections.unmodifiableList(arguments);
    }

    /**
     * Converts the data contained in this Message into a raw {@code String} that could
     * be sent to an IRC server.
     */
    public String toRaw() {
        StringBuilder messageBuilder = new StringBuilder();

        if(prefix != null) {
            messageBuilder.append(prefix).append(" ");
        }

        messageBuilder.append(command);

        for(String argument : arguments) {
            messageBuilder.append(" ");
            if(argument.chars().anyMatch(Character::isWhitespace)) {
                messageBuilder.append(":").append(argument);
                break;
            } else {
                messageBuilder.append(argument);
            }
        }

        return messageBuilder.toString();
    }

    /**
     * Construct a new Message from the specified raw data.
     * @param raw the raw data received from the server
     */
    public static Message fromRaw(final String raw) {
        String[] components = raw.split(" ", 3);
        String prefix = null;
        String command = null;
        List<String> arguments = new ArrayList<>();
        int index = 0;

        // TODO: Make a constant for the prefix designator.
        if(raw.startsWith(":")) {
            prefix = components[index++];
        }

        command = components[index++];

        String[] rawArguments = components[index].split(" ");

        for(int i = 0; i < rawArguments.length; i++) {
            String argument = rawArguments[i];
            // TODO: Also make a constant for this, which means the rest of line is just part of this single argument.
            // If the argument starts with this designator, it means the rest of the line is
            // part of this one single argument.
            if(argument.startsWith(":")) {
                StringBuilder argumentBuilder = new StringBuilder(argument.substring(1));
                i++;

                // Continue through the rest of the line appending it to the argument.
                // Since `i` is used here to continue looping, it will be incremented for
                // the parent loop as well, causing it to exit afterwards.
                for(; i < rawArguments.length; i++) {
                    argumentBuilder.append(" ").append(rawArguments[i]);
                }

                argument = argumentBuilder.toString();
            }
            
            arguments.add(argument);
        }

        String[] args = arguments.toArray(new String[0]);

        // Construct the Message we have read.
        if(command.chars().allMatch(Character::isDigit)) {
            // The command is a sequence of numbers, return a NumericMessage.
            return new NumericMessage(prefix, Integer.parseInt(command), args);
        } else if (command.equals("PRIVMSG") && args.length == 2) {
            return new PrivateMessage(prefix, args[0], args[1]);
        } else {
            // Unspecialized message.
            return new Message(prefix, command, args);
        }
    }

    /**
     * Create a NICK message to send to a server.
     * 
     * NICK message is used to give user a nickname or change the previous
     * one.
     * 
     * @param nick the client's nickname
     * @return the Nick message
     */
    public static Message createNickMessage(final String nick) {
        return new Message(null, "NICK", nick);
    }

    /**
     * Create a registration USER message to send to a server.
     * 
     * The USER message is used at the beginning of connection to specify
     * the username, hostname, servername and realname of s new user.  It is
     * also used in communication between servers to indicate new user
     * arriving on IRC, since only after both USER and NICK have been
     * received from a client does a user become registered.
     * 
     * @param username the user's user name
     * @param realname the user's real name
     * @return the User message
     */
    public static Message createUserMessage(final String username, final String realname) {
        return new Message(null, "USER", username, "0", "*", realname);
    }
}