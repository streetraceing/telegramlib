package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.JsonArray;

import java.util.HashMap;

public class ReactionType extends JsonArray {
    public ReactionType emoji(String value) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("type", "emoji");
        data.put("emoji", value);
        add(data);
        return this;
    }

    public ReactionType custom_emoji(String value) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("type", "emoji");
        data.put("custom_emoji_id", value);
        add(data);
        return this;
    }
}