package net.strdev.telegramlib.types;

import net.strdev.telegramlib.json.types.Message;
import net.strdev.telegramlib.json.types.base.Chat;
import net.strdev.telegramlib.json.types.base.User;

public class EditedMessageEvent {
    public String text;
    public User from;
    public Chat chat;
    public long date;
    public Integer message_id;
    public Integer edit_date;

    public EditedMessageEvent(Message message) {
        this.text = message.text;
        this.from = message.from;
        this.chat = message.chat;
        this.date = message.date;
        this.message_id = message.message_id;
        this.edit_date = message.edit_date;
    }
}