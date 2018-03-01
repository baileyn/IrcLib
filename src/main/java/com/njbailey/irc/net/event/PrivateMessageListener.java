package com.njbailey.irc.net.event;

import com.njbailey.irc.core.messages.PrivateMessage;

public interface PrivateMessageListener {
    void onPrivateMessage(PrivateMessage message);
}