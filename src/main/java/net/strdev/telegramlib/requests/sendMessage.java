package net.strdev.telegramlib.requests;

import net.strdev.telegramlib.network.TelegramRequest;
import net.strdev.telegramlib.types.serializable.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class sendMessage extends TelegramRequest {
    public sendMessage(String token) {
        super(token, "sendMessage");
    }

    public sendMessage() {
        super("sendMessage");
    }

    public sendMessage business_connection_id(String value) {
        addQuery("business_connection_id", value);
        return this;
    }

    public sendMessage chat_id(long value) {
        addQuery("chat_id", value);
        return this;
    }

    public sendMessage chat_id(String value) {
        addQuery("chat_id", value);
        return this;
    }

    public sendMessage message_thread_id(int value) {
        addQuery("message_thread_id", value);
        return this;
    }

    public sendMessage text(String value) {
        addQuery("text", value);
        return this;
    }

    public sendMessage parse_mode(String value) {
        addQuery("parse_mode", value);
        return this;
    }

    public sendMessage entities(MessageEntity[] value) {
        addQuery("entities", Arrays.stream(value).map(MessageEntity::asString).collect(Collectors.toList()));
        return this;
    }

    public sendMessage link_preview_options(LinkPreviewOptions value) {
        addQuery("link_preview_options", value.asString());
        return this;
    }

    public sendMessage disable_notification(boolean value) {
        addQuery("disable_notification", value);
        return this;
    }

    public sendMessage protect_content(boolean value) {
        addQuery("protect_content", value);
        return this;
    }

    public sendMessage allow_paid_broadcast(boolean value) {
        addQuery("allow_paid_broadcast", value);
        return this;
    }

    public sendMessage message_effect_id(String value) {
        addQuery("message_effect_id", value);
        return this;
    }

    public sendMessage reply_parameters(ReplyParameters value) {
        addQuery("reply_parameters", value.asString());
        return this;
    }

    public sendMessage reply_markup(InlineKeyboardMarkup value) {
        addQuery("reply_markup", value.asString());
        return this;
    }

    public sendMessage reply_markup(ReplyKeyboardMarkup value) {
        addQuery("reply_markup", value.asString());
        return this;
    }

    public sendMessage reply_markup(ReplyKeyboardRemove value) {
        addQuery("reply_markup", value.asString());
        return this;
    }

    public sendMessage reply_markup(ForceReply value) {
        addQuery("reply_markup", value.asString());
        return this;
    }
}
