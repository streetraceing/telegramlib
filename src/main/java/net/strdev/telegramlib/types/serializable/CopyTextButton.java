package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.JsonObject;

public class CopyTextButton extends JsonObject {
    public CopyTextButton(String text) {
        add("text", text);
    }
}
