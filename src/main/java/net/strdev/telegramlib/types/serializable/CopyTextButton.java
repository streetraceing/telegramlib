package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.TelegramSerializable;

public class CopyTextButton extends TelegramSerializable {
    public CopyTextButton(String text) {
        add("text", text);
    }
}
