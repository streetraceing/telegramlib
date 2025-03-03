package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.JsonObject;

public class WebAppInfo extends JsonObject {
    public WebAppInfo(String url) {
        add("url", url);
    }
}
