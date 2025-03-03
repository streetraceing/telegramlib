package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class TextQuote {
    public String text;
    public List<MessageEntity> entities;
    public Integer position;
    public boolean is_manual;
}
