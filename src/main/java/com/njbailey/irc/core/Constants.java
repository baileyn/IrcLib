package com.njbailey.irc;
public class Constants {
/**
 * The first message sent after client registration. The text used varies widely
 */
public static final int RPL_WELCOME = 1;
/**
 * Part of the post-registration greeting. Text varies widely
 */
public static final int RPL_YOURHOST = 2;
/**
 * Part of the post-registration greeting. Text varies widely
 */
public static final int RPL_CREATED = 3;
/**
 * Part of the post-registration greeting
 */
public static final int RPL_MYINFO = 4;
/**
 * Sent by the server to a user to suggest an alternative server, sometimes used when 
 * the connection is refused because the server is already full. Also known as RPL_SLINE 
 * (AustHex), and RPL_REDIR Also see #010.
 */
public static final int RPL_BOUNCE = 5;
/**
 * See RFC
 */
public static final int RPL_TRACELINK = 200;
/**
 * See RFC
 */
public static final int RPL_TRACECONNECTING = 201;
/**
 * See RFC
 */
public static final int RPL_TRACEHANDSHAKE = 202;
/**
 * See RFC
 */
public static final int RPL_TRACEUNKNOWN = 203;
/**
 * See RFC
 */
public static final int RPL_TRACEOPERATOR = 204;
/**
 * See RFC
 */
public static final int RPL_TRACEUSER = 205;
/**
 * See RFC
 */
public static final int RPL_TRACESERVER = 206;
/**
 * See RFC
 */
public static final int RPL_TRACESERVICE = 207;
/**
 * See RFC
 */
public static final int RPL_TRACENEWTYPE = 208;
/**
 * See RFC
 */
public static final int RPL_TRACECLASS = 209;
/**
 * 
 */
public static final int RPL_TRACERECONNECT = 210;
/**
 * Reply to STATS (See RFC)
 */
public static final int RPL_STATSLINKINFO = 211;
/**
 * Reply to STATS (See RFC)
 */
public static final int RPL_STATSCOMMANDS = 212;
/**
 * Reply to STATS (See RFC)
 */
public static final int RPL_STATSCLINE = 213;
/**
 * Reply to STATS (See RFC), Also known as RPL_STATSOLDNLINE (ircu, Unreal)
 */
public static final int RPL_STATSNLINE = 214;
/**
 * Reply to STATS (See RFC)
 */
public static final int RPL_STATSILINE = 215;
/**
 * Reply to STATS (See RFC)
 */
public static final int RPL_STATSKLINE = 216;
/**
 * 
 */
public static final int RPL_STATSQLINE = 217;
/**
 * Reply to STATS (See RFC)
 */
public static final int RPL_STATSYLINE = 218;
/**
 * End of RPL_STATS* list.
 */
public static final int RPL_ENDOFSTATS = 219;
/**
 * Information about a user's own modes. Some daemons have extended the mode command 
 * and certain modes take parameters (like channel modes).
 */
public static final int RPL_UMODEIS = 221;
/**
 * 
 */
public static final int RPL_SERVICEINFO = 231;
/**
 * 
 */
public static final int RPL_ENDOFSERVICES = 232;
/**
 * 
 */
public static final int RPL_SERVICE = 233;
/**
 * A service entry in the service list
 */
public static final int RPL_SERVLIST = 234;
/**
 * Termination of an RPL_SERVLIST list
 */
public static final int RPL_SERVLISTEND = 235;
/**
 * 
 */
public static final int RPL_STATSVLINE = 240;
/**
 * Reply to STATS (See RFC)
 */
public static final int RPL_STATSLLINE = 241;
/**
 * Reply to STATS (See RFC)
 */
public static final int RPL_STATSUPTIME = 242;
/**
 * Reply to STATS (See RFC); The info field is an extension found in some IRC daemons, 
 * which returns info such as an e-mail address or the name/job of an operator
 */
public static final int RPL_STATSOLINE = 243;
/**
 * Reply to STATS (See RFC)
 */
public static final int RPL_STATSHLINE = 244;
/**
 * 
 */
public static final int RPL_STATSPING = 246;
/**
 * 
 */
public static final int RPL_STATSBLINE = 247;
/**
 * 
 */
public static final int RPL_STATSDLINE = 250;
/**
 * Reply to LUSERS command, other versions exist (eg. RFC2812); Text may vary.
 */
public static final int RPL_LUSERCLIENT = 251;
/**
 * Reply to LUSERS command - Number of IRC operators online
 */
public static final int RPL_LUSEROP = 252;
/**
 * Reply to LUSERS command - Number of unknown/unregistered connections
 */
public static final int RPL_LUSERUNKNOWN = 253;
/**
 * Reply to LUSERS command - Number of channels formed
 */
public static final int RPL_LUSERCHANNELS = 254;
/**
 * Reply to LUSERS command - Information about local connections; Text may vary.
 */
public static final int RPL_LUSERME = 255;
/**
 * Start of an RPL_ADMIN* reply. In practise, the server parameter is often never given, 
 * and instead the info field contains the text 'Administrative info about <server>'. 
 * Newer daemons seem to follow the RFC and output the server's hostname in 
 * the 'server' parameter, but also output the server name in the text as per traditional 
 * daemons.
 */
public static final int RPL_ADMINME = 256;
/**
 * Reply to ADMIN command (Location, first line)
 */
public static final int RPL_ADMINLOC1 = 257;
/**
 * Reply to ADMIN command (Location, second line)
 */
public static final int RPL_ADMINLOC2 = 258;
/**
 * Reply to ADMIN command (E-mail address of administrator)
 */
public static final int RPL_ADMINEMAIL = 259;
/**
 * See RFC
 */
public static final int RPL_TRACELOG = 261;
/**
 * Used to terminate a list of RPL_TRACE* replies
 */
public static final int RPL_TRACEEND = 262;
/**
 * When a server drops a command without processing it, it MUST use this reply. Also 
 * known as RPL_LOAD_THROTTLED and RPL_LOAD2HI, I'm presuming they do the same thing.
 */
public static final int RPL_TRYAGAIN = 263;
/**
 * Dummy reply, supposedly only used for debugging/testing new features, however has 
 * appeared in production daemons.
 */
public static final int RPL_NONE = 300;
/**
 * Used in reply to a command directed at a user who is marked as away
 */
public static final int RPL_AWAY = 301;
/**
 * Reply used by USERHOST (see RFC)
 */
public static final int RPL_USERHOST = 302;
/**
 * Reply to the ISON command (see RFC)
 */
public static final int RPL_ISON = 303;
/**
 * Reply from AWAY when no longer marked as away
 */
public static final int RPL_UNAWAY = 305;
/**
 * Reply from AWAY when marked away
 */
public static final int RPL_NOWAWAY = 306;
/**
 * Reply to WHOIS - Information about the user
 */
public static final int RPL_WHOISUSER = 311;
/**
 * Reply to WHOIS - What server they're on
 */
public static final int RPL_WHOISSERVER = 312;
/**
 * Reply to WHOIS - User has IRC Operator privileges
 */
public static final int RPL_WHOISOPERATOR = 313;
/**
 * Reply to WHOWAS - Information about the user
 */
public static final int RPL_WHOWASUSER = 314;
/**
 * Used to terminate a list of RPL_WHOREPLY replies
 */
public static final int RPL_ENDOFWHO = 315;
/**
 * 
 */
public static final int RPL_WHOISCHANOP = 316;
/**
 * Reply to WHOIS - Idle information
 */
public static final int RPL_WHOISIDLE = 317;
/**
 * Reply to WHOIS - End of list
 */
public static final int RPL_ENDOFWHOIS = 318;
/**
 * Reply to WHOIS - Channel list for user (See RFC)
 */
public static final int RPL_WHOISCHANNELS = 319;
/**
 * Channel list - Header
 */
public static final int RPL_LISTSTART = 321;
/**
 * Channel list - A channel
 */
public static final int RPL_LIST = 322;
/**
 * Channel list - End of list
 */
public static final int RPL_LISTEND = 323;
/**
 * 
 */
public static final int RPL_CHANNELMODEIS = 324;
/**
 * 
 */
public static final int RPL_UNIQOPIS = 325;
/**
 * Response to TOPIC when no topic is set
 */
public static final int RPL_NOTOPIC = 331;
/**
 * Response to TOPIC with the set topic
 */
public static final int RPL_TOPIC = 332;
/**
 * Returned by the server to indicate that the attempted INVITE message was successful 
 * and is being passed onto the end client. Note that RFC1459 documents the parameters 
 * in the reverse order. The format given here is the format used on production 
 * servers, and should be considered the standard reply above that given by RFC1459.
 */
public static final int RPL_INVITING = 341;
/**
 * Returned by a server answering a SUMMON message to indicate that it is summoning 
 * that user
 */
public static final int RPL_SUMMONING = 342;
/**
 * An invite mask for the invite mask list
 */
public static final int RPL_INVITELIST = 346;
/**
 * Termination of an RPL_INVITELIST list
 */
public static final int RPL_ENDOFINVITELIST = 347;
/**
 * An exception mask for the exception mask list. Also known as RPL_EXLIST (Unreal, 
 * Ultimate)
 */
public static final int RPL_EXCEPTLIST = 348;
/**
 * Termination of an RPL_EXCEPTLIST list. Also known as RPL_ENDOFEXLIST (Unreal, Ultimate)
 */
public static final int RPL_ENDOFEXCEPTLIST = 349;
/**
 * Reply by the server showing its version details, however this format is not often 
 * adhered to
 */
public static final int RPL_VERSION = 351;
/**
 * Reply to vanilla WHO (See RFC). This format can be very different if the 'WHOX' 
 * version of the command is used (see ircu).
 */
public static final int RPL_WHOREPLY = 352;
/**
 * Reply to NAMES (See RFC)
 */
public static final int RPL_NAMREPLY = 353;
/**
 * 
 */
public static final int RPL_KILLDONE = 361;
/**
 * 
 */
public static final int RPL_CLOSING = 362;
/**
 * 
 */
public static final int RPL_CLOSEEND = 363;
/**
 * Reply to the LINKS command
 */
public static final int RPL_LINKS = 364;
/**
 * Termination of an RPL_LINKS list
 */
public static final int RPL_ENDOFLINKS = 365;
/**
 * Termination of an RPL_NAMREPLY list
 */
public static final int RPL_ENDOFNAMES = 366;
/**
 * A ban-list item (See RFC); <time left> and <reason> are additions used by KineIRCd
 */
public static final int RPL_BANLIST = 367;
/**
 * Termination of an RPL_BANLIST list
 */
public static final int RPL_ENDOFBANLIST = 368;
/**
 * Reply to WHOWAS - End of list
 */
public static final int RPL_ENDOFWHOWAS = 369;
/**
 * Reply to INFO
 */
public static final int RPL_INFO = 371;
/**
 * Reply to MOTD
 */
public static final int RPL_MOTD = 372;
/**
 * 
 */
public static final int RPL_INFOSTART = 373;
/**
 * Termination of an RPL_INFO list
 */
public static final int RPL_ENDOFINFO = 374;
/**
 * Start of an RPL_MOTD list
 */
public static final int RPL_MOTDSTART = 375;
/**
 * Termination of an RPL_MOTD list
 */
public static final int RPL_ENDOFMOTD = 376;
/**
 * Successful reply from OPER
 */
public static final int RPL_YOUREOPER = 381;
/**
 * Successful reply from REHASH
 */
public static final int RPL_REHASHING = 382;
/**
 * Sent upon successful registration of a service
 */
public static final int RPL_YOURESERVICE = 383;
/**
 * 
 */
public static final int RPL_MYPORTIS = 384;
/**
 * Response to the TIME command. The string format may vary greatly. Also see #679.
 */
public static final int RPL_TIME = 391;
/**
 * Start of an RPL_USERS list
 */
public static final int RPL_USERSSTART = 392;
/**
 * Response to the USERS command (See RFC)
 */
public static final int RPL_USERS = 393;
/**
 * Termination of an RPL_USERS list
 */
public static final int RPL_ENDOFUSERS = 394;
/**
 * Reply to USERS when nobody is logged in
 */
public static final int RPL_NOUSERS = 395;
/**
 * Used to indicate the nickname parameter supplied to a command is currently unused
 */
public static final int ERR_NOSUCHNICK = 401;
/**
 * Used to indicate the server name given currently doesn't exist
 */
public static final int ERR_NOSUCHSERVER = 402;
/**
 * Used to indicate the given channel name is invalid, or does not exist
 */
public static final int ERR_NOSUCHCHANNEL = 403;
/**
 * Sent to a user who does not have the rights to send a message to a channel
 */
public static final int ERR_CANNOTSENDTOCHAN = 404;
/**
 * Sent to a user when they have joined the maximum number of allowed channels and 
 * they tried to join another channel
 */
public static final int ERR_TOOMANYCHANNELS = 405;
/**
 * Returned by WHOWAS to indicate there was no history information for a given nickname
 */
public static final int ERR_WASNOSUCHNICK = 406;
/**
 * The given target(s) for a command are ambiguous in that they relate to too many 
 * targets
 */
public static final int ERR_TOOMANYTARGETS = 407;
/**
 * Returned to a client which is attempting to send an SQUERY (or other message) to 
 * a service which does not exist
 */
public static final int ERR_NOSUCHSERVICE = 408;
/**
 * PING or PONG message missing the originator parameter which is required since these 
 * commands must work without valid prefixes
 */
public static final int ERR_NOORIGIN = 409;
/**
 * Returned when no recipient is given with a command
 */
public static final int ERR_NORECIPIENT = 411;
/**
 * Returned when NOTICE/PRIVMSG is used with no message given
 */
public static final int ERR_NOTEXTTOSEND = 412;
/**
 * Used when a message is being sent to a mask without being limited to a top-level 
 * domain (i.e. * instead of *.au)
 */
public static final int ERR_NOTOPLEVEL = 413;
/**
 * Used when a message is being sent to a mask with a wild-card for a top level domain 
 * (i.e. *.*)
 */
public static final int ERR_WILDTOPLEVEL = 414;
/**
 * Used when a message is being sent to a mask with an invalid syntax
 */
public static final int ERR_BADMASK = 415;
/**
 * Returned when the given command is unknown to the server (or hidden because of lack 
 * of access rights)
 */
public static final int ERR_UNKNOWNCOMMAND = 421;
/**
 * Sent when there is no MOTD to send the client
 */
public static final int ERR_NOMOTD = 422;
/**
 * Returned by a server in response to an ADMIN request when no information is available. 
 * RFC1459 mentions this in the list of numerics. While it's not listed as a 
 * valid reply in section 4.3.7 ('Admin command'), it's confirmed to exist in the 
 * real world.
 */
public static final int ERR_NOADMININFO = 423;
/**
 * Generic error message used to report a failed file operation during the processing 
 * of a command
 */
public static final int ERR_FILEERROR = 424;
/**
 * Returned when a nickname parameter expected for a command isn't found
 */
public static final int ERR_NONICKNAMEGIVEN = 431;
/**
 * Returned after receiving a NICK message which contains a nickname which is considered 
 * invalid, such as it's reserved ('anonymous') or contains characters considered 
 * invalid for nicknames. This numeric is misspelt, but remains with this name 
 * for historical reasons :)
 */
public static final int ERR_ERRONEUSNICKNAME = 432;
/**
 * Returned by the NICK command when the given nickname is already in use
 */
public static final int ERR_NICKNAMEINUSE = 433;
/**
 * Returned by a server to a client when it detects a nickname collision
 */
public static final int ERR_NICKCOLLISION = 436;
/**
 * Return when the target is unable to be reached temporarily, eg. a delay mechanism 
 * in play, or a service being offline
 */
public static final int ERR_UNAVAILRESOURCE = 437;
/**
 * Returned by the server to indicate that the target user of the command is not on 
 * the given channel
 */
public static final int ERR_USERNOTINCHANNEL = 441;
/**
 * Returned by the server whenever a client tries to perform a channel effecting command 
 * for which the client is not a member
 */
public static final int ERR_NOTONCHANNEL = 442;
/**
 * Returned when a client tries to invite a user to a channel they're already on
 */
public static final int ERR_USERONCHANNEL = 443;
/**
 * Returned by the SUMMON command if a given user was not logged in and could not be 
 * summoned
 */
public static final int ERR_NOLOGIN = 444;
/**
 * Returned by SUMMON when it has been disabled or not implemented
 */
public static final int ERR_SUMMONDISABLED = 445;
/**
 * Returned by USERS when it has been disabled or not implemented
 */
public static final int ERR_USERSDISABLED = 446;
/**
 * Returned by the server to indicate that the client must be registered before the 
 * server will allow it to be parsed in detail
 */
public static final int ERR_NOTREGISTERED = 451;
/**
 * Returned by the server by any command which requires more parameters than the number 
 * of parameters given
 */
public static final int ERR_NEEDMOREPARAMS = 461;
/**
 * Returned by the server to any link which attempts to register again
 */
public static final int ERR_ALREADYREGISTERED = 462;
/**
 * Returned to a client which attempts to register with a server which has been configured 
 * to refuse connections from the client's host
 */
public static final int ERR_NOPERMFORHOST = 463;
/**
 * Returned by the PASS command to indicate the given password was required and was 
 * either not given or was incorrect
 */
public static final int ERR_PASSWDMISMATCH = 464;
/**
 * Returned to a client after an attempt to register on a server configured to ban 
 * connections from that client
 */
public static final int ERR_YOUREBANNEDCREEP = 465;
/**
 * Sent by a server to a user to inform that access to the server will soon be denied
 */
public static final int ERR_YOUWILLBEBANNED = 466;
/**
 * Returned when the channel key for a channel has already been set
 */
public static final int ERR_KEYSET = 467;
/**
 * Returned when attempting to join a channel which is set +l and is already full
 */
public static final int ERR_CHANNELISFULL = 471;
/**
 * Returned when a given mode is unknown
 */
public static final int ERR_UNKNOWNMODE = 472;
/**
 * Returned when attempting to join a channel which is invite only without an invitation
 */
public static final int ERR_INVITEONLYCHAN = 473;
/**
 * Returned when attempting to join a channel a user is banned from
 */
public static final int ERR_BANNEDFROMCHAN = 474;
/**
 * Returned when attempting to join a key-locked channel either without a key or with 
 * the wrong key
 */
public static final int ERR_BADCHANNELKEY = 475;
/**
 * The given channel mask was invalid
 */
public static final int ERR_BADCHANMASK = 476;
/**
 * Returned when attempting to set a mode on a channel which does not support channel 
 * modes, or channel mode changes. Also known as ERR_MODELESS
 */
public static final int ERR_NOCHANMODES = 477;
/**
 * Returned when a channel access list (i.e. ban list etc) is full and cannot be added 
 * to
 */
public static final int ERR_BANLISTFULL = 478;
/**
 * Returned by any command requiring special privileges (eg. IRC operator) to indicate 
 * the operation was unsuccessful
 */
public static final int ERR_NOPRIVILEGES = 481;
/**
 * Returned by any command requiring special channel privileges (eg. channel operator) 
 * to indicate the operation was unsuccessful
 */
public static final int ERR_CHANOPRIVSNEEDED = 482;
/**
 * Returned by KILL to anyone who tries to kill a server
 */
public static final int ERR_CANTKILLSERVER = 483;
/**
 * Sent by the server to a user upon connection to indicate the restricted nature of 
 * the connection (i.e. usermode +r)
 */
public static final int ERR_RESTRICTED = 484;
/**
 * Any mode requiring 'channel creator' privileges returns this error if the client 
 * is attempting to use it while not a channel creator on the given channel
 */
public static final int ERR_UNIQOPRIVSNEEDED = 485;
/**
 * Returned by OPER to a client who cannot become an IRC operator because the server 
 * has been configured to disallow the client's host
 */
public static final int ERR_NOOPERHOST = 491;
/**
 * 
 */
public static final int ERR_NOSERVICEHOST = 492;
/**
 * Returned by the server to indicate that a MODE message was sent with a nickname 
 * parameter and that the mode flag sent was not recognised
 */
public static final int ERR_UMODEUNKNOWNFLAG = 501;
/**
 * Error sent to any user trying to view or change the user mode for a user other than 
 * themselves
 */
public static final int ERR_USERSDONTMATCH = 502;
}