package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.JsonObject;

public class MessageEntity extends JsonObject {
    public MessageEntity type(String value) {
        add("type", value);
        return this;
    }

    public MessageEntity offset(int value) {
        add("offset", value);
        return this;
    }

    public MessageEntity length(int value) {
        add("length", value);
        return this;
    }

    public MessageEntity url(String value) {
        add("url", value);
        return this;
    }

    public MessageEntity language(String value) {
        add("language", value);
        return this;
    }

    public MessageEntity custom_emoji_id(String value) {
        add("custom_emoji_id", value);
        return this;
    }

    public MessageEntity user(User value) {
        add("user", value.asMap());
        return this;
    }
}