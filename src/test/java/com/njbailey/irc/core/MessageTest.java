package com.njbailey.irc.core;

import org.junit.Test;
import org.junit.Assert;

public class MessageTest {
    @Test
    public void rawFromMessageNoPrefix() {
        Message message = new Message(null, "PRIVMSG", "#hello", "how are you today?");

        Assert.assertEquals("PRIVMSG #hello :how are you today?", message.toRaw());
    }

    @Test
    public void rawFromMessageWithPrefix() {
        Message message = new Message(":baileyn!username@hostname", "PRIVMSG", "#hello", "how are you today?");

        Assert.assertEquals(":baileyn!username@hostname PRIVMSG #hello :how are you today?", message.toRaw());
    }

    @Test
    public void parseMessageFromValidRaw() {
        Message message = Message.fromRaw(":baileyn!username@hostname PRIVMSG #hello :how are you today?");

        Assert.assertTrue(message.hasPrefix());
        Assert.assertEquals(":baileyn!username@hostname", message.getPrefix());
        Assert.assertEquals("PRIVMSG", message.getCommand());
        Assert.assertArrayEquals(new String[] {"#hello", "how are you today?"}, message.getArguments().toArray(new String[0]));
    }

    @Test
    public void messageToRawWithSingleArgument() {
        Message message = new Message(null, "JOIN", "#ircbots");

        Assert.assertEquals("JOIN #ircbots", message.toRaw());
    }
}