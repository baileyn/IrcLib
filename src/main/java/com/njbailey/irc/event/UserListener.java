package com.njbailey.irc.event;

import com.njbailey.irc.core.Channel;
import com.njbailey.irc.core.User;

public interface UserListener {
    void userAdded(Channel channel, User user);

    void userRemoved(Channel channel, User user);
}
