package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.TelegramSerializable;

public class WebAppInfo extends TelegramSerializable {
    public WebAppInfo(String url) {
        add("url", url);
    }
}
