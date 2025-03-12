package net.strdev.telegramlib.requests;

import net.strdev.telegramlib.network.TelegramRequest;

public class forwardMessage extends TelegramRequest {
    public forwardMessage(String token) {
        super(token, "deleteMessage");
    }

    public forwardMessage() {
        super("deleteMessage");
    }

    public forwardMessage chat_id(long value) {
        addQuery("chat_id", value);
        return this;
    }

    public forwardMessage chat_id(String value) {
        addQuery("chat_id", value);
        return this;
    }

    public forwardMessage message_thread_id(int value) {
        addQuery("message_thread_id", value);
        return this;
    }

    public forwardMessage message_id(int value) {
        addQuery("message_id", value);
        return this;
    }

    public forwardMessage from_chat_id(long value) {
        addQuery("from_chat_id", value);
        return this;
    }

    public forwardMessage from_chat_id(String value) {
        addQuery("from_chat_id", value);
        return this;
    }

    public forwardMessage video_start_timestamp(int value) {
        addQuery("video_start_timestamp", value);
        return this;
    }

    public forwardMessage disable_notification(boolean value) {
        addQuery("disable_notification", value);
        return this;
    }

    public forwardMessage protect_content(boolean value) {
        addQuery("protect_content", value);
        return this;
    }
}
