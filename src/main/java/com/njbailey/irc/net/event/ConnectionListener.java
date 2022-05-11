package com.njbailey.irc.net.event;

import com.njbailey.irc.net.Network;

public interface ConnectionListener {
    void connectionAcquired(Network network);
    void connectionLost(Network network);
}