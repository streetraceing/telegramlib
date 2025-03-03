package net.strdev.telegramlib.types;

import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.json.types.Message;
import net.strdev.telegramlib.json.types.ForwardedMessage;
import net.strdev.telegramlib.json.types.base.Chat;
import net.strdev.telegramlib.json.types.base.MessageEntity;
import net.strdev.telegramlib.json.types.base.TextQuote;
import net.strdev.telegramlib.json.types.base.User;
import net.strdev.telegramlib.types.scheme.MessageScheme;

import java.util.List;

public class TextMessage extends MessageScheme {
    public String text;
    public ForwardedMessage reply_to_message;
    public Chat sender_chat;
    public TextQuote quote;
    public User via_bot;
    public List<MessageEntity> entities;

    public TextMessage (Message message, Bot bot) {
        super(message, bot);
        this.entities = message.entities;
        this.text = message.text;
        this.quote = message.quote;
        this.sender_chat = message.sender_chat;
        this.via_bot = message.via_bot;
        this.reply_to_message = message.reply_to_message;
    }
}