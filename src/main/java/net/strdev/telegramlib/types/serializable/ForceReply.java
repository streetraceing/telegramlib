package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.JsonObject;

public class ForceReply extends JsonObject {
    public ForceReply() {
        add("force_reply", true);
    }

    public ForceReply input_field_placeholder(String value) {
        add("input_field_placeholder", value);
        return this;
    }

    public ForceReply selective(boolean selective) {
        add("selective", selective);
        return this;
    }
}
