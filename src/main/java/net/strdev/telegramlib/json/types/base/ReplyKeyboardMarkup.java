package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class ReplyKeyboardMarkup {
    public List<KeyboardButton> keyboard;
    public boolean is_persistent;
    public boolean resize_keyboard;
    public boolean one_time_keyboard;
    public String input_field_placeholder;
    public boolean selective;
}
