package com.njbailey.irc.core;

import org.junit.Test;
import org.junit.Assert;

public class UserTest {
    @Test
    public void createUserFromPrefixFailure() {
        String prefix = ":irc.servername.com";

        Assert.assertNull(User.fromPrefix(prefix));
    }

    @Test
    public void createUserFromPrefixSuccess() {
        String prefix = ":baileyn!nicholas@my.super.hostname";

        User user = User.fromPrefix(prefix);

        Assert.assertEquals(user.getNickname(), "baileyn");
        Assert.assertEquals(user.getUsername(), "nicholas");
        Assert.assertEquals(user.getHostname(), "my.super.hostname");
    }
}