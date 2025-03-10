package net.strdev.telegramlib.requests;

import net.strdev.telegramlib.json.Json;
import net.strdev.telegramlib.json.types.base.LinkPreviewOptions;
import net.strdev.telegramlib.network.TelegramRequest;
import net.strdev.telegramlib.types.serializable.InlineKeyboardMarkup;
import net.strdev.telegramlib.types.serializable.MessageEntity;

import java.util.Arrays;
import java.util.stream.Collectors;

public class editMessageText extends TelegramRequest {
    public editMessageText(String token) {
        super(token, "editMessageText");
    }

    public editMessageText() {
        super("editMessageText");
    }

    public editMessageText business_connection_id(String value) {
        addQuery("business_connection_id", value);
        return this;
    }

    public editMessageText chat_id(String value) {
        addQuery("chat_id", value);
        return this;
    }

    public editMessageText chat_id(long value) {
        addQuery("chat_id", value);
        return this;
    }

    public editMessageText message_id(int value) {
        addQuery("message_id", value);
        return this;
    }

    public editMessageText inline_message_id(String value) {
        addQuery("inline_message_id", value);
        return this;
    }

    public editMessageText text(String value) {
        addQuery("text", value);
        return this;
    }

    public editMessageText parse_mode(String value) {
        addQuery("parse_mode", value);
        return this;
    }

    public editMessageText entities(MessageEntity[] value) {
        addQuery("entities", Arrays.stream(value).map(MessageEntity::asString).collect(Collectors.toList()));
        return this;
    }

    public editMessageText link_preview_options(LinkPreviewOptions value) {
        addQuery("link_preview_options", Json.parser.toJson(value));
        return this;
    }

    public editMessageText reply_markup(InlineKeyboardMarkup value) {
        addQuery("reply_markup", value.asString());
        return this;
    }
}
