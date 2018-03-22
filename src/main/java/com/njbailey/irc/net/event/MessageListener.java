package com.njbailey.irc.net.event;

import com.njbailey.irc.core.Message;

public interface MessageListener {
    void messageReceived(Message message);
}
