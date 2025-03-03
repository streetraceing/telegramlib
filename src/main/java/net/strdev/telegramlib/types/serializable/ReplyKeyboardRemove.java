package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.JsonObject;

public class ReplyKeyboardRemove extends JsonObject {
    public ReplyKeyboardRemove() {
        add("remove_keyboard", true);
    }

    public ReplyKeyboardRemove selective(boolean value) {
        add("selective", value);
        return this;
    }
}
