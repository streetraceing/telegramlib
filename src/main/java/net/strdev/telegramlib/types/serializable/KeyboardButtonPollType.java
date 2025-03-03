package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.JsonObject;

public class KeyboardButtonPollType extends JsonObject {
    public KeyboardButtonPollType(String type) {
        add("type", type);
    }
}
