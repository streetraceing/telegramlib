package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.JsonObject;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InlineKeyboardMarkup extends JsonObject {
    public InlineKeyboardMarkup(InlineKeyboardButton[][] inline_keyboard) {
        add("inline_keyboard", Arrays.stream(inline_keyboard).map(n -> Arrays.stream(n).map(JsonObject::asMap).collect(Collectors.toList())).collect(Collectors.toList()));
    }
}
