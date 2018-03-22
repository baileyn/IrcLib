package com.njbailey.irc.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CursorUpdater extends MouseAdapter {
    private Cursor cursor;
    private JComponent component;

    public CursorUpdater(JComponent component, Cursor cursor) {
        this.component = component;
        this.cursor = cursor;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        component.setCursor(cursor);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        component.setCursor(Cursor.getDefaultCursor());
    }
}
