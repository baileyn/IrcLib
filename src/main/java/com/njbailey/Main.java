package com.njbailey;

import com.njbailey.irc.net.NetworkHandler;

public class Main {
    public static void main(String[] args) {
        NetworkHandler handler = new NetworkHandler();
        handler.addNetwork("irc.mozilla.org", 6667);
        handler.addNetwork("irc.freenode.net", 6667);
    }
}