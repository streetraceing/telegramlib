package net.strdev.telegramlib.types.scheme;

import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.json.types.Message;
import net.strdev.telegramlib.json.types.base.Chat;
import net.strdev.telegramlib.json.types.base.User;

public class MessageScheme {
    public Integer message_id;
    public User from;
    public Chat chat;
    public long date;
    protected Bot bot;

    public MessageScheme(Message message, Bot bot) {
        this.bot = bot;
        this.from = message.from;
        this.chat = message.chat;
        this.date = message.date;
        this.message_id = message.message_id;
    }

    public int send(String text) {
        bot.sendText(text, chat.id);
        return message_id+1;
    }

    public int reply(String text) {
        bot.replyMessageText(chat.id, message_id, text);
        return message_id+1;
    }

    public void react(String emoji) {
        bot.addReaction(chat.id, message_id, emoji);
    }
}
