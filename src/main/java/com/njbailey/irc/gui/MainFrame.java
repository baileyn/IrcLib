package com.njbailey.irc.gui;

import com.njbailey.irc.core.Channel;
import com.njbailey.irc.core.Message;
import com.njbailey.irc.core.MessageTarget;
import com.njbailey.irc.net.Network;
import com.njbailey.irc.net.NetworkHandler;
import com.njbailey.irc.net.event.ConnectionListener;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame implements ActionListener, WindowListener {
    private NetworkHandler networkHandler = new NetworkHandler();

    private List<ClientPanel<? extends MessageTarget>> panelList = new ArrayList<>();
    private ClientPanel<? extends MessageTarget> currentPanel;
    private InputArea inputArea = new InputArea();
    private TargetList targetList = new TargetList(this);

    private JSplitPane mainSplitPane = new JSplitPane();

    public MainFrame() {
        setupDefaultLookAndFeel();

        setTitle("Irc Client");

        setupComponents();

        super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        super.addWindowListener(this);

        pack();
        setSize(800, 600);
    }

    private void addServer(String server, int port) {
        Network network = networkHandler.addNetwork(server, port);

        network.addConnectionListener(new ConnectionListener() {
            @Override
            public void connectionAcquired(Network network) {
                network.send(Message.createNickMessage("kruptox"));
                network.send(Message.createUserMessage("baileyn", "Nicholas Bailey"));
            }

            @Override
            public void connectionLost(Network network) {

            }
        });

        network.addNumericMessageListener(message -> {
            if (message.getNumeric() == 4) {
                addPanel(new NetworkPanel(MainFrame.this, network));
            }
        });
    }

    public void addPanel(ClientPanel<? extends MessageTarget> panel) {
        panelList.add(panel);
        System.out.println("Should add");
        targetList.addTarget(panel.getTarget());
        setCurrentPanel(panel);
    }

    public void setCurrentPanel(ClientPanel<? extends MessageTarget> panel) {
        if (currentPanel != null) {
            mainSplitPane.remove(currentPanel);
        }

        currentPanel = panel;
        mainSplitPane.setRightComponent(panel);
        revalidate();
        repaint();
    }

    public void setCurrentPanel(Validator validator) {
        ClientPanel<? extends MessageTarget> panel = getPanel(validator);

        if (panel != null) {
            setCurrentPanel(panel);
        }
    }

    public ClientPanel<? extends MessageTarget> getPanel(Validator validator) {
        for (ClientPanel<? extends MessageTarget> panel : panelList) {
            if (validator.isValid(panel)) {
                return panel;
            }
        }

        return null;
    }

    private void setupComponents() {
        JMenuBar menuBar = setupMenuBar();
        super.setJMenuBar(menuBar);

        inputArea.addActionListener(this);

        JPanel panel = new JPanel(new BorderLayout());

        //panel.add(targetList, BorderLayout.WEST);
        mainSplitPane.setLeftComponent(targetList);
        panel.add(mainSplitPane);
        panel.add(inputArea, BorderLayout.SOUTH);

        super.setContentPane(panel);
    }

    private JMenuBar setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu connectionMenu = new JMenu("Connections");
        JMenuItem addConnection = new JMenuItem("Add Connection");
        addConnection.addActionListener(action -> {
            addServer("irc.mozilla.org", 6667);
        });

        connectionMenu.add(addConnection);
        menuBar.add(connectionMenu);

        return menuBar;
    }

    private void setupDefaultLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException
                | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inputArea) {
            Network network = null;

            if (currentPanel.getTarget() instanceof Network) {
                network = (Network) currentPanel.getTarget();
            } else if (currentPanel.getTarget() instanceof Channel) {
                network = ((Channel) currentPanel.getTarget()).getNetwork();
            }

            if (network != null) {
                network.send(Message.fromRaw(inputArea.getText()));
                inputArea.setText("");
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        networkHandler.close();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
