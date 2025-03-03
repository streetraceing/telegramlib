package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.JsonObject;

public class LoginUrl extends JsonObject {
    public LoginUrl url(String value) {
        add("url", value);
        return this;
    }

    public LoginUrl forward_text(String value) {
        add("forward_text", value);
        return this;
    }

    public LoginUrl bot_username(String value) {
        add("bot_username", value);
        return this;
    }

    public LoginUrl request_write_access(boolean value) {
        add("request_write_access", value);
        return this;
    }
}
