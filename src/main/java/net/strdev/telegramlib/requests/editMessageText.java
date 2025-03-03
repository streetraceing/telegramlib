package net.strdev.telegramlib.requests;

import net.strdev.telegramlib.json.Json;
import net.strdev.telegramlib.json.types.base.InlineKeyboardMarkup;
import net.strdev.telegramlib.json.types.base.LinkPreviewOptions;
import net.strdev.telegramlib.json.types.base.MessageEntity;
import net.strdev.telegramlib.network.TelegramRequest;

import java.util.List;

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

    public editMessageText entities(List<MessageEntity> value) {
        addQuery("entities", Json.parser.toJson(value));
        return this;
    }

    public editMessageText link_preview_options(LinkPreviewOptions value) {
        addQuery("link_preview_options", Json.parser.toJson(value));
        return this;
    }

    public editMessageText reply_markup(InlineKeyboardMarkup value) {
        addQuery("reply_markup", Json.parser.toJson(value));
        return this;
    }
}
