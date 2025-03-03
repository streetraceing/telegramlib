package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.JsonObject;

public class KeyboardButtonRequestChat extends JsonObject {
    public KeyboardButtonRequestChat user_administrator_rights(ChatAdministratorRights value) {
        add("user_administrator_rights", null);
        return this;
    }

    public KeyboardButtonRequestChat bot_administrator_rights(ChatAdministratorRights value) {
        add("bot_administrator_rights", null);
        return this;
    }

    public KeyboardButtonRequestChat request_id(long value) {
        add("request_id", value);
        return this;
    }

    public KeyboardButtonRequestChat chat_is_channel(boolean value) {
        add("chat_is_channel", value);
        return this;
    }

    public KeyboardButtonRequestChat chat_is_forum(boolean value) {
        add("chat_is_forum", value);
        return this;
    }

    public KeyboardButtonRequestChat chat_has_username(boolean value) {
        add("chat_has_username", value);
        return this;
    }

    public KeyboardButtonRequestChat chat_is_created(boolean value) {
        add("chat_is_created", value);
        return this;
    }

    public KeyboardButtonRequestChat bot_is_member(boolean value) {
        add("bot_is_member", value);
        return this;
    }

    public KeyboardButtonRequestChat request_title(boolean value) {
        add("request_title", value);
        return this;
    }

    public KeyboardButtonRequestChat request_username(boolean value) {
        add("request_username", value);
        return this;
    }

    public KeyboardButtonRequestChat request_photo(boolean value) {
        add("request_photo", value);
        return this;
    }
}
