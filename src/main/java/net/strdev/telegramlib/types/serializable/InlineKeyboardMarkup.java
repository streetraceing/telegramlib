package net.strdev.telegramlib.types.serializable;

import net.strdev.telegramlib.types.serializable.base.TelegramSerializable;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InlineKeyboardMarkup extends TelegramSerializable {
    public InlineKeyboardMarkup(InlineKeyboardButton[][] inline_keyboard) {
        add("inline_keyboard", Arrays.stream(inline_keyboard).map(n -> Arrays.stream(n).map(TelegramSerializable::asMap).collect(Collectors.toList())).collect(Collectors.toList()));
    }
}
