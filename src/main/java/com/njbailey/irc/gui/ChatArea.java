package com.njbailey.irc.gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.awt.*;

public class ChatArea extends JTextPane implements DocumentListener {
    public ChatArea() {
        ((DefaultCaret) super.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        super.setEditable(false);
        super.addMouseListener(new CursorUpdater(this, Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR)));
        super.getStyledDocument().addDocumentListener(this);
    }

    /**
     * Output a line to the {@code ChatArea}
     *
     * The line is affixed with a new line if it does not already exist.
     *
     * @param data the data to write
     */
    public void writeLine(String data) {
        if(!data.endsWith("\n")) {
            data = data + "\n";
        }

        writeText(data);
    }

    public void writeText(String data) {
        StyledDocument document = super.getStyledDocument();
        int length = document.getLength();

        try {
            document.insertString(length, data, null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }
}
