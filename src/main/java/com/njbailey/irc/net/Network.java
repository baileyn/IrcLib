package com.njbailey.irc.net;

import com.njbailey.irc.core.Channel;
import com.njbailey.irc.core.Message;
import com.njbailey.irc.core.MessageTarget;
import com.njbailey.irc.core.User;
import com.njbailey.irc.core.messages.NumericMessage;
import com.njbailey.irc.core.messages.PrivateMessage;
import com.njbailey.irc.event.ChannelConnectionListener;
import com.njbailey.irc.impl.DefaultNumericHandler;
import com.njbailey.irc.net.event.ConnectionListener;
import com.njbailey.irc.net.event.MessageListener;
import com.njbailey.irc.net.event.NumericMessageListener;
import com.njbailey.irc.net.event.PrivateMessageListener;
import io.netty.channel.socket.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a Network that's connected to by the Internet Relay Chat.
 */
public class Network implements MessageTarget {
    private SocketChannel channel;
    private final String host;
    private final int port;
    private User client;

    private String name;
    private List<Channel> channels = new ArrayList<Channel>();
    private List<User> users = new ArrayList<User>();

    private List<MessageListener> messageListeners = new ArrayList<>();
    private List<ConnectionListener> connectionListeners = new ArrayList<>();
    private List<NumericMessageListener> numericMessageListeners = new ArrayList<>();
    private List<PrivateMessageListener> privateMessageListeners = new ArrayList<>();
    private List<ChannelConnectionListener> channelConnectionListeners  = new ArrayList<>();

    public Network(final String host, final int port) {
        this.host = host;
        this.port = port;

        addNumericMessageListener(new DefaultNumericHandler(this));
    }

    @Override
    public String getName() {
        return name;
    }

    public void setChannel(final SocketChannel channel) {
        this.channel = channel;
    }

    public void destroyChannel() {
        this.channel = null;
    }

    /**
     * Adds a {@code ConnectionListener} for this {@code Network}.
     */
    public void addConnectionListener(ConnectionListener connectionListener) {
        this.connectionListeners.add(connectionListener);
    }

    public void addMessageListener(MessageListener messageListener) {
        this.messageListeners.add(messageListener);
    }

    public void removeMessageListener(MessageListener messageListener) {
        this.messageListeners.remove(messageListener);
    }

    /**
     * Adds a {@code NumericMessageListener} for this {@code Network}.
     */
    public void addNumericMessageListener(NumericMessageListener messageListener) {
        this.numericMessageListeners.add(messageListener);
    }

    /**
     * Adds a {@code PrivateMessageListener} for this {@code Network}.
     */
    public void addPrivateMessageListener(PrivateMessageListener messageListener) {
        this.privateMessageListeners.add(messageListener);
    }

    public void addChannelConnectionListener(ChannelConnectionListener connectionListener) {
        this.channelConnectionListeners.add(connectionListener);
    }

    public void removeChannelConnectionListener(ChannelConnectionListener connectionListener) {
        this.channelConnectionListeners.remove(connectionListener);
    }

    /**
     * This function is called whenever the client has successfully connected to the network.
     */
    public void connected() {
        connectionListeners.forEach(listener -> listener.connectionAcquired(this));
    }

    /**
     * This function is called whenever the client has been disconnected from the network.
     */
    public void dropped() {
        connectionListeners.forEach(listener -> listener.connectionLost(this));
    }

    /**
     * Return the client user.
     * @return the client user
     */
    public User getClient() {
        return client;
    }

    /**
     * Create the client user with the specified nickname.
     * @param nickname the nickname for the client
     */
    public void createClient(final String nickname) {
        this.client = new User(nickname);
    }

    /**
     * Called when a {@code Message} is received from the server.
     */
    public void messageReceived(Message message) {
        messageListeners.forEach(listener -> listener.messageReceived(message));

        if(message instanceof NumericMessage) {
            NumericMessage numericMessage = (NumericMessage) message;

            if(numericMessage.getNumeric() == 4) {
                name = message.getArguments().get(0);
            }

            numericMessageListeners.forEach(listener -> listener.onNumericMessage(numericMessage));
        } else if (message instanceof PrivateMessage) {
            PrivateMessage msg = (PrivateMessage) message;
            final PrivateMessage privateMessage;

            // Update the target if it's a private message.
            if(msg.getTarget().equalsIgnoreCase(client.getNickname())) {
                privateMessage = new PrivateMessage(msg.getPrefix(), msg.getSender(), msg.getMessage());
            } else {
                privateMessage = msg;
            }

            privateMessageListeners.forEach(listener -> listener.onPrivateMessage(privateMessage));
        } else {
            if(message.getCommand().equals("PING")) {
                send(new Message(null, "PONG", message.getArguments().toArray(new String[0])));
            }

            System.out.println("Message {");
            System.out.println("\tPrefix: " + message.getPrefix());
            System.out.println("\tCommand: " + message.getCommand());
            System.out.println("\tArguments: " + Arrays.toString(message.getArguments().toArray()));
            System.out.println("}");
        }
    }

    /**
     * Sends the specified {@code Message} to the server.
     * 
     * Note: this function will automatically flush the stream.
     * 
     * @param message the {@code Message} to send
     */
    public void send(Message message) {
        if(channel != null) {
            channel.writeAndFlush(message);
        }
    }

    /**
     * Try to find a user with the specified name, and if they
     * don't exist, create them and add them to the list.
     */
    public User addOrGetUser(final String nickname) {
        User user = null;

        if(getClient().getNickname().equalsIgnoreCase(nickname)) {
            return getClient();
        }

        for(User u : users) {
            if(u.getNickname().equalsIgnoreCase(nickname)) {
                user = u;
                break;
            }
        }

        if(user == null) {
            user = new User(nickname);
            users.add(user);
        }

        return user;
    }

    /**
     * Try to find a channel with the specified name, and if it doesn't 
     * exist create it and add it to the list.
     * 
     * @param name the name of the channel
     * 
     * @return the channel that was in the list
     */
    public Channel addOrGetChannel(final String name) {
        Channel channel = null;

        for(Channel c : channels) {
            if(c.getName().equalsIgnoreCase(name)) {
                channel = c;
                break;
            }
        }

        if(channel == null) {
            Channel newChan = new Channel(name);
            channels.add(newChan);
            this.channelConnectionListeners.forEach(listener -> listener.joined(newChan));
            channel = newChan;
        }

        return channel;
    }

    /**
     * Return the channel with the specified name.
     * 
     * @param name the name of the channel
     * @return the channel with the specified name
     */
    public Channel getChannel(final String name) {
        for(Channel c : channels) {
            if(c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }

        return null;
    }

    public void close() {
        channel.close();
    }
}
