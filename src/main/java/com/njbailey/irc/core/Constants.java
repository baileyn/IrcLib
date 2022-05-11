package com.njbailey.irc;
public class Constants {
    /**
     * Used to indicate the nickname parameter supplied to a
     * command is currently unused.
     */
    public static final int ERR_NOSUCHNICK = 401;
    /**
     * Used to indicate the server name given currently
     * doesn't exist.
     */
    public static final int ERR_NOSUCHSERVER = 402;
    /**
     * Used to indicate the given channel name is invalid.
     */
    public static final int ERR_NOSUCHCHANNEL = 403;
    /**
     * Sent to a user who is either (a) not on a channel
     * which is mode +n or (b) not a chanop (or mode +v) on
     * a channel which has mode +m set and is trying to send
     * a PRIVMSG message to that channel.
     */
    public static final int ERR_CANNOTSENDTOCHAN = 404;
    /**
     * Sent to a user when they have joined the maximum
     * number of allowed channels and they try to join
     * another channel.
     */
    public static final int ERR_TOOMANYCHANNELS = 405;
    /**
     * Returned by WHOWAS to indicate there is no history
     * information for that nickname.
     */
    public static final int ERR_WASNOSUCHNICK = 406;
    /**
     * Returned to a client which is attempting to send a
     * PRIVMSG/NOTICE using the user@host destination format
     * and for a user@host which has several occurrences. 
     */
    public static final int ERR_TOOMANYTARGETS = 407;
    /**
     * PING or PONG message missing the originator parameter
     * which is required since these commands must work
     * without valid prefixes.
     */
    public static final int ERR_NOORIGIN = 409;
    /**
     * No recipient given.
     */
    public static final int ERR_NORECIPIENT = 411;
    /**
     * No text to send.
     */
    public static final int ERR_NOTEXTTOSEND = 412;
    /**
     * No toplevel domain specified.
     */
    public static final int ERR_NOTOPLEVEL = 413;
    /**
     * Wildcard in toplevel domain.
     */
    public static final int ERR_WILDTOPLEVEL = 414;
    /**
     * Returned to a registered client to indicate that the
     * command sent is unknown by the server.
     */
    public static final int ERR_UNKNOWNCOMMAND = 421;
    /**
     * Server's MOTD file could not be opened by the server.
     */
    public static final int ERR_NOMOTD = 422;
    /**
     *  Returned by a server in response to an ADMIN message
     * when there is an error in finding the appropriate
     * information.
     */
    public static final int ERR_NOADMININFO = 423;
    /**
     * Generic error message used to report a failed file
     *operation during the processing of a message.
     */
    public static int ERR_FILEERROR = 424;
    /**
     * Returned by the server whenever a client tries to
     * perform a channel effecting command for which the
     * client isn't a member.
     */
}