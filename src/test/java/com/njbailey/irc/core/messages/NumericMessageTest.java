package com.njbailey.irc.core.messages;

import org.junit.Test;
import com.njbailey.irc.core.Message;
import org.junit.Assert;

public class NumericMessageTest {
    @Test
    public void constructNumericMessage() {
        Message message = new NumericMessage(":server", 4, "kruptox", "belew.mozilla.org", "InspIRCd-2.0");
    
        Assert.assertEquals("004", message.getCommand());
    }
}