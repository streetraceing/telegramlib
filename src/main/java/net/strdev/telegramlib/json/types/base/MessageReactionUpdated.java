package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class MessageReactionUpdated {
    public Chat chat;
    public Integer message_id;
    public User user;
    public Chat actor_chat;
    public long date;
    public List<ReactionType> old_reaction;
    public List<ReactionType> new_reaction;
}
