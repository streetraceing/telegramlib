package net.strdev.telegramlib.commands;

import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.json.types.base.Chat;
import net.strdev.telegramlib.json.types.base.User;

public class CommandResponse {
    public String[] args;
    protected Bot bot;
    public Integer message_id;
    public User from;
    public Chat chat;
    public long date;

    public CommandResponse(int message_id, long date, Chat chat, User from, String[] args, Bot bot) {
        this.args = args;
        this.message_id = message_id;
        this.from = from;
        this.chat = chat;
        this.date = date;
        this.bot = bot;
    }

    public void send(String text) {
        bot.sendText(text, chat.id);
    }

    public int reply(String text) {
        bot.replyMessage(chat.id, message_id, text);
        return message_id+1;
    }

    public void react(String emoji) {
        bot.addReaction(chat.id, message_id, emoji);
    }
}
