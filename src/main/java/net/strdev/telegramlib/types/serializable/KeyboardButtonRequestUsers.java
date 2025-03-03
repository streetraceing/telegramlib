package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.TelegramSerializable;

public class KeyboardButtonRequestUsers extends TelegramSerializable {
    public KeyboardButtonRequestUsers request_id(int value) {
        add("request_id", value);
        return this;
    }

    public KeyboardButtonRequestUsers user_is_bot(boolean value) {
        add("user_is_bot", value);
        return this;
    }

    public KeyboardButtonRequestUsers user_is_premium(boolean value) {
        add("user_is_premium", value);
        return this;
    }

    public KeyboardButtonRequestUsers max_quantity(int value) {
        add("max_quantity", value);
        return this;
    }

    public KeyboardButtonRequestUsers request_name(boolean value) {
        add("request_name", value);
        return this;
    }

    public KeyboardButtonRequestUsers request_username(boolean value) {
        add("request_username", value);
        return this;
    }

    public KeyboardButtonRequestUsers request_photo(boolean value) {
        add("request_photo", value);
        return this;
    }
}
