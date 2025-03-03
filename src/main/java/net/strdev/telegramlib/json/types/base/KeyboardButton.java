package net.strdev.telegramlib.json.types.base;

public class KeyboardButton {
    public String text;
    public KeyboardButtonRequestUsers request_users;
    public KeyboardButtonRequestChat request_chat;
    public boolean request_contact;
    public boolean request_location;
    public KeyboardButtonPollType request_poll;
    public WebAppInfo web_app;
}
