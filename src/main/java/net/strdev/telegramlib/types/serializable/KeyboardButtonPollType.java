package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.TelegramSerializable;

public class KeyboardButtonPollType extends TelegramSerializable {
    public KeyboardButtonPollType(String type) {
        add("type", type);
    }
}
