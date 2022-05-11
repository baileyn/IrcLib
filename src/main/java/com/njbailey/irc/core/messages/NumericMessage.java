package com.njbailey.irc.core.messages;

import com.njbailey.irc.core.Message;

public class NumericMessage extends Message {
    private final int numeric;

    /**
     * Create a new NumericMessage with the specified prefix, numeric, and arguments.
     * 
     * @param prefix the message prefix
     * @param numeric the message command
     * @param arguments the message arguments
     */
    public NumericMessage(String prefix, int numeric, String... arguments) {
        super(prefix, String.format("%03d", numeric), arguments);
        this.numeric = numeric;

        // Numeric _MUST_ be 3 digits. If it's more, throw an exception.
        if (numeric > 999) {
            throw new IllegalArgumentException("numeric must be in the range (0,999]");
        }
    }

    /**
     * Return the {@code command} parsed as an integer.
     * @return the {@code command} parsed as an integer.
     */
    public int getNumeric() {
        return numeric;
    }
}