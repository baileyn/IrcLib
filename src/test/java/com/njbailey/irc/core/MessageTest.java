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
        Message message = new Message("baileyn!username@hostname", "PRIVMSG", "#hello", "how are you today?");

        Assert.assertEquals(":baileyn!username@hostname PRIVMSG #hello :how are you today?", message.toRaw());
    }
}