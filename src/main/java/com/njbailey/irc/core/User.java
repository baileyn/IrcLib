package com.njbailey.irc.core;

/**
 * Represents a User connected to an IRC server.
 */
public class User implements MessageTarget {
    private String nickname;
    private String username;
    private String hostname;
    
    /**
     * Create a new User with the specified nickname.
     * 
     * @param nickanem the User's nickname
     */
    public User(String nickname) {
        this(nickname, null, null);
    }

    /**
     * Create a new User with the specified nickname, username, and hostname.
     * 
     * @param nickname the User's nickname
     * @param username the User's username
     * @param hostname the User's hostname
     */
    public User(String nickname, String username, String hostname) {
        this.nickname = nickname;
        this.username = username;
        this.hostname = hostname;
    }

    /**
     * Create a new User from the prefix of an IRC message. 
     * 
     * The prefix supplied to this function should retain the ':' prefix.
     * 
     * @return the User created from the prefix, or null if it's not a user.
     */
    public static User fromPrefix(String prefix) {
        String[] components = prefix.substring(1).split("[!@]");

        if(components.length != 3) {
            return null;
        }

        return new User(components[0], components[1], components[2]);
    }

    @Override
    public String getName() {
        return getNickname();
    }

    /**
     * Return the User's nickname.
     * @return the User's nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Return the User's username.
     * @return the User's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Return the User's hostname.
     * @return the User's hostname
     */
    public String getHostname() {
        return hostname;
    }

    @Override
    public String toString() {
        return nickname;
    }
}