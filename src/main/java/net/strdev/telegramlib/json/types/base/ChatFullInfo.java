package net.strdev.telegramlib.json.types.base;

import net.strdev.telegramlib.json.types.Message;

import java.util.List;

public class ChatFullInfo {
    public long id;
    public String type;
    public String title;
    public String username;
    public String first_name;
    public String last_name;
    public boolean is_forum;
    public Integer accent_color_id;
    public Integer max_reaction_count;
    public ChatPhoto photo;
    public List<String> active_usernames;
    public Birthdate birthdate;
    public BusinessIntro business_intro;
    public BusinessLocation business_location;
    public BusinessOpeningHours business_opening_hours;
    public Chat personal_chat;
    public List<ReactionType> available_reactions;
    public String background_custom_emoji_id;
    public Integer profile_accent_color_id;
    public String profile_background_custom_emoji_id;
    public String emoji_status_custom_emoji_id;
    public Integer emoji_status_expiration_date;
    public String bio;
    public boolean has_private_forwards;
    public boolean has_restricted_voice_and_video_messages;
    public boolean join_to_send_messages;
    public boolean join_by_request;
    public String description;
    public String invite_link;
    public Message pinned_message;
    public ChatPermissions permissions;
    public boolean can_send_gift;
    public boolean can_send_paid_media;
    public Integer slow_mode_delay;
    public Integer unrestrict_boost_count;
    public Integer message_auto_delete_time;
    public boolean has_aggressive_anti_spam_enabled;
    public boolean has_hidden_members;
    public boolean has_protected_content;
    public boolean has_visible_history;
    public String sticker_set_name;
    public boolean can_set_sticker_set;
    public String custom_emoji_sticker_set_name;
    public Integer linked_chat_id;
    public ChatLocation location;
}
