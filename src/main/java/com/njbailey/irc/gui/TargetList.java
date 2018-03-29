package com.njbailey.irc.gui;

import com.njbailey.irc.core.MessageTarget;

import javax.swing.*;
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
}
