package com.njbailey.irc.core.messages;

import com.njbailey.irc.core.Message;
import com.njbailey.irc.core.MessageTarget;

public class PrivateMessage extends Message {
    /**
     * Createa a new PrivateMessage to send the specified message to the specified target.
     * 
     * @param target the target to send the message to
     * @param message the message to send
     */
    public PrivateMessage(MessageTarget target, String message) {
        this(target.getName(), message);
    }

    public PrivateMessage(String target, String message) {
        super(null, "PRIVMSG", target, message);
    }
}