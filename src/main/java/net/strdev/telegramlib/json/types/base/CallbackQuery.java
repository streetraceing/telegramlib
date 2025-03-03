package net.strdev.telegramlib.json.types.base;

import net.strdev.telegramlib.json.types.ForwardedMessage;

public class CallbackQuery {
    public String id;
    public User from;
    public ForwardedMessage message;
    public String inline_message_id;
    public String chat_instance;
    public String data;
    public String game_short_name;
}
