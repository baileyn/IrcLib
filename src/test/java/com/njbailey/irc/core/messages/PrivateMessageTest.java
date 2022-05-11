package com.njbailey.irc.core.messages;

import org.junit.Test;
import com.njbailey.irc.core.Message;
import org.junit.Assert;

public class PrivateMessageTest {
    @Test
    public void constructSimplePrivateMessage() {
        PrivateMessage message = new PrivateMessage("#ircbots", "This is a test message");
        Assert.assertEquals("PRIVMSG #ircbots :This is a test message", message.toRaw());
        Assert.assertEquals("#ircbots", message.getTarget());
    }

    @Test
    public void constructPrivateWithMessagePrefix() {
        PrivateMessage message = new PrivateMessage(":baileyn!name@hostname", "#ircbots", "This is a test message");
        Assert.assertEquals(":baileyn!name@hostname PRIVMSG #ircbots :This is a test message", message.toRaw());
        Assert.assertEquals("#ircbots", message.getTarget());
        Assert.assertEquals("baileyn", message.getSender());
        Assert.assertEquals("This is a test message", message.getMessage());
    }
}