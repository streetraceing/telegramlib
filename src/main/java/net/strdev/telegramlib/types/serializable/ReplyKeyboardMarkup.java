package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.JsonObject;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReplyKeyboardMarkup extends JsonObject {
    public ReplyKeyboardMarkup keyboard(KeyboardButton[][] value) {
        add("keyboard", Arrays.stream(value).map(n -> Arrays.stream(n).map(JsonObject::asMap).collect(Collectors.toList())).collect(Collectors.toList()));
        return this;
    }

    public ReplyKeyboardMarkup is_persistent(boolean value) {
        add("is_persistent", value);
        return this;
    }

    public ReplyKeyboardMarkup resize_keyboard(boolean value) {
        add("resize_keyboard", value);
        return this;
    }

    public ReplyKeyboardMarkup one_time_keyboard(boolean value) {
        add("one_time_keyboard", value);
        return this;
    }

    public ReplyKeyboardMarkup input_field_placeholder(String value) {
        add("input_field_placeholder", value);
        return this;
    }

    public ReplyKeyboardMarkup selective(boolean value) {
        add("selective", value);
        return this;
    }
}