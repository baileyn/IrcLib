package com.njbailey.irc.core.messages;

import com.njbailey.irc.core.Message;

public class NumericMessage extends Message {
    private final int numeric;

    public NumericMessage(String prefix, int numeric, String... arguments) {
        super(prefix, String.format("%03d", numeric), arguments);
        this.numeric = numeric;
    }

    /**
     * Return the {@code command} parsed as an integer.
     * @return the {@code command} parsed as an integer.
     */
    public int getNumeric() {
        return numeric;
    }
}