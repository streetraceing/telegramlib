package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.TelegramSerializable;

public class ReplyParameters extends TelegramSerializable {
    public ReplyParameters(Integer message_id) {
        add("message_id", message_id);
    }

    public ReplyParameters chat_id(int value) {
        add("chat_id", value);
        return this;
    }

    public ReplyParameters chat_id(String value) {
        add("chat_id", value);
        return this;
    }

    public ReplyParameters quote(String value) {
        add("quote", value);
        return this;
    }

    public ReplyParameters allow_sending_without_reply(boolean value) {
        add("allow_sending_without_reply", value);
        return this;
    }
}
