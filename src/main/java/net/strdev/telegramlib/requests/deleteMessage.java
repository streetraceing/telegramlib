package net.strdev.telegramlib.requests;

import net.strdev.telegramlib.network.TelegramRequest;

public class deleteMessage extends TelegramRequest {
    public deleteMessage(String token) {
        super(token, "deleteMessage");
    }

    public deleteMessage() {
        super("deleteMessage");
    }

    public deleteMessage chat_id(long value) {
        addQuery("chat_id", value);
        return this;
    }

    public deleteMessage chat_id(String value) {
        addQuery("chat_id", value);
        return this;
    }

    public deleteMessage message_id(int value) {
        addQuery("message_id", value);
        return this;
    }
}
