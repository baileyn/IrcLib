package com.njbailey.irc.gui;

import com.njbailey.irc.core.MessageTarget;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TargetList extends JList<String> {
    private final MainFrame mainFrame;
    private DefaultListModel<String> model = new DefaultListModel<>();

    public TargetList(MainFrame mainFrame) {
        super.setModel(model);
        this.mainFrame = mainFrame;

        super.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    mainFrame.setCurrentPanel(
                            i -> i.getTarget().getName().equalsIgnoreCase(TargetList.super.getSelectedValue()));
                }
            }
        });
    }

    public void addTarget(MessageTarget target) {
        model.addElement(target.getName());
    }

    @Override
    public Dimension getPreferredSize() {
        Font currentFont = getFont();
        FontMetrics metrics = getFontMetrics(currentFont);

        int longestLength = -1;

        for (int i = 0; i < model.size(); i++) {
            String item = model.elementAt(i);

            int length = metrics.stringWidth(item);

            if (length < longestLength) {
                longestLength = length;
            }
        }

        Dimension size = super.getPreferredSize();
        return new Dimension(longestLength, (int) size.getHeight());
    }
}
