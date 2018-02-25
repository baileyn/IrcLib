package com.njbailey.irc.net.event;

import com.njbailey.irc.core.messages.NumericMessage;

public interface NumericMessageListener {
    void onNumericMessage(NumericMessage message);
}