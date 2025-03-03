package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class InputMediaPhoto {
    public String type;
    public String media;
    public String caption;
    public String parse_mode;
    public List<MessageEntity> caption_entities;
    public boolean show_caption_above_media;
    public boolean has_spoiler;
}
