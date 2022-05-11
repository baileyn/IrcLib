package com.njbailey.irc.gui;

import javax.swing.*;
import java.awt.*;

public class ClientPanel<E> extends JPanel {
    private E e;

    public ClientPanel(LayoutManager layout, E e) {
        super(layout);
        this.e = e;
    }

    public ClientPanel(E e) {
        this.e = e;
    }

    public E getTarget() {
        return e;
    }
}
