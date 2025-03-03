package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.JsonObject;

public class User extends JsonObject {
    public User id(int value) {
        add("id", value);
        return this;
    }

    public User is_bot(boolean value) {
        add("is_bot", value);
        return this;
    }

    public User first_name(String value) {
        add("first_name", value);
        return this;
    }

    public User last_name(String value) {
        add("last_name", value);
        return this;
    }

    public User username(String value) {
        add("username", value);
        return this;
    }

    public User language_code(String value) {
        add("language_code", value);
        return this;
    }

    public User is_premium(boolean value) {
        add("is_premium", value);
        return this;
    }

    public User added_to_attachment_menu(boolean value) {
        add("added_to_attachment_menu", value);
        return this;
    }

    public User can_join_groups(boolean value) {
        add("can_join_groups", value);
        return this;
    }

    public User can_read_all_group_messages(boolean value) {
        add("can_read_all_group_messages", value);
        return this;
    }

    public User supports_inline_queries(boolean value) {
        add("supports_inline_queries", value);
        return this;
    }

    public User can_connect_to_business(boolean value) {
        add("can_connect_to_business", value);
        return this;
    }

    public User has_main_web_app(boolean value) {
        add("has_main_web_app", value);
        return this;
    }
}
