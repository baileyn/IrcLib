package com.njbailey;

import com.njbailey.irc.core.Message;
import com.njbailey.irc.net.Network;
import com.njbailey.irc.net.NetworkHandler;
import com.njbailey.irc.net.event.ConnectionListener;

public class Main {
    public static void main(String[] args) {
        NetworkHandler handler = new NetworkHandler();
        Network network = handler.addNetwork("irc.mozilla.org", 6667);
        network.addConnectionListener(new ConnectionListener(){
            @Override
            public void connectionLost(Network network) {
                // Do nothing.
            }
        
            @Override
            public void connectionAcquired(Network network) {    
                network.send(Message.createNickMessage("kruptox"));
                network.send(Message.createUserMessage("baileyn", "Nicholas Bailey"));
            }
        });
    }
}