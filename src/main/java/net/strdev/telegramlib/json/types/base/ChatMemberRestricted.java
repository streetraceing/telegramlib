package net.strdev.telegramlib.json.types.base;

public class ChatMemberRestricted {
    public String status;
    public User user;
    public boolean is_member;
    public boolean can_send_messages;
    public boolean can_send_audios;
    public boolean can_send_documents;
    public boolean can_send_photos;
    public boolean can_send_videos;
    public boolean can_send_video_notes;
    public boolean can_send_voice_notes;
    public boolean can_send_polls;
    public boolean can_send_other_messages;
    public boolean can_add_web_page_previews;
    public boolean can_change_info;
    public boolean can_invite_users;
    public boolean can_pin_messages;
    public boolean can_manage_topics;
    public Integer until_date;
}
