package com.njbailey.irc.gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;

import com.njbailey.irc.core.Message;
import com.njbailey.irc.core.messages.PrivateMessage;

import java.awt.*;
import java.util.Date;
import java.time.LocalTime;
import java.util.Date;
import java.time.format.DateTimeFormatter;



public class ChatArea extends JTextPane implements DocumentListener {
    public ChatArea() {
        ((DefaultCaret) super.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        super.setEditable(false);
        super.addMouseListener(new CursorUpdater(this, Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR)));
        super.getStyledDocument().addDocumentListener(this);
    }

    public void write(PrivateMessage message) {
        String channel = message.getTarget();
        String sender = message.getSender();
        String msg = message.getMessage();
        
       // writeLine(somePrettyFormattingOfThePrivateMessage);
    }

    /**
     * Output a line to the {@code ChatArea}
     *
     * The line is affixed with a new line if it does not already exist.
     *
     * @param data the data to write
     */
    public void writeLine(String data) {
        if (!data.endsWith("\n")) {
            data = data + "\n";
        }

        writeText(timeStamp() + data);
    }
    /**
     * Retrieves the current LocalTime. Formats to HH:mm:ss.
     * Returns string for timeStamp to be printed with messages.
     */
    public String timeStamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime currentTime = LocalTime.now();
        String formattedTime = formatter.format(currentTime);

        return " [" + formattedTime +  "]";
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
