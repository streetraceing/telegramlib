package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.JsonObject;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReplyParameters extends JsonObject {
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

    public ReplyParameters quote_parse_mode(String value) {
        add("quote_parse_mode", value);
        return this;
    }

    public ReplyParameters quote_entities(MessageEntity[] value) {
        add("quote_entities", Arrays.stream(value).map(MessageEntity::asMap).collect(Collectors.toList()));
        return this;
    }
}