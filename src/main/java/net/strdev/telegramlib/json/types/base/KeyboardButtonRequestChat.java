package net.strdev.telegramlib.json.types.base;

public class KeyboardButtonRequestChat {
    public Integer request_id;
    public boolean chat_is_channel;
    public boolean chat_is_forum;
    public boolean chat_has_username;
    public boolean chat_is_created;
    public ChatAdministratorRights user_administrator_rights;
    public ChatAdministratorRights bot_administrator_rights;
    public boolean bot_is_member;
    public boolean request_title;
    public boolean request_username;
    public boolean request_photo;
}
