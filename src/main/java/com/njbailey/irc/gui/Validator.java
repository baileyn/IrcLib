package com.njbailey.irc.gui;

import com.njbailey.irc.core.MessageTarget;

public interface Validator {
    boolean isValid(ClientPanel<? extends MessageTarget> panel);
}
