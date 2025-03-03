package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.TelegramSerializable;

public class ReplyKeyboardRemove extends TelegramSerializable {
    public ReplyKeyboardRemove() {
        add("remove_keyboard", true);
    }

    public ReplyKeyboardRemove selective(boolean value) {
        add("selective", value);
        return this;
    }
}
