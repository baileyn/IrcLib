package com.njbailey.irc.core.messages;

import com.njbailey.irc.core.Message;
import com.njbailey.irc.core.MessageTarget;

public class PrivateMessage extends Message {
    private String target;
    private String message;
    private String sender;

    /**
     * Create a new PrivateMessage to send the specified message to the specified target.
     * 
     * @param sender the sender of the message
     * @param target the target to send the message to
     * @param message the message to send
     */
    public PrivateMessage(MessageTarget sender, MessageTarget target, String message) {
        this(target.getName(), message);
        this.sender = sender.getName();
    }
    
    /**
     * Create a new PrivateMessage to send the specified message to the specified target.
     * 
     * @param sender the sender of the message
     * @param target the target to send the message to
     * @param message the message to send.
     */
    public PrivateMessage(String prefix, MessageTarget target, String message) {
        super(prefix, target.getName(), message);
        this.target = target.getName();
    }

    /**
     * Create a new PrivateMessage to send the specified message to the specified target.
     * 
     * @param prefix the message prefix
     * @param target the message target
     * @param message the message contents
     */
    public PrivateMessage(String prefix, String target, String message) {
        super(prefix, "PRIVMSG", target, message);
        this.target = target;
        this.message = message;
    }

    /**
     * Create a new PrivateMessage to send the specified message to the specified target.
     * 
     * @param target the target to send the message to
     * @param message the message to send
     */
    public PrivateMessage(String target, String message) {
        super(null, "PRIVMSG", target, message);
        this.target = target;
    }

    /**
     * Return the target of this private message. 
     * 
     * By default, when a private message is received, the "target" is the 
     * client's nickname. To ensure that all users of the library can just respond
     * to the "target" as if it's a channel, it's switched to be the user that
     * private messaged the client.
     * 
     * @return the target of this private message
     */
    public String getTarget() {
        return target;
    }

    /**
     * Return the message for this private message.
     * @return the message for this private message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Return the sender for this private message.
     * @return the sender for this private message
     */
    public String getSender() {
        if(getPrefix() == null) {
            return null;
        }

        if(sender != null) {
            return sender;
        }

        String prefix = getPrefix().substring(1);

        String[] parts = prefix.split("[@!]");

        return this.sender = parts[0];
    }
}