package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class InputMediaAnimation {
    public String type;
    public String media;
    public String thumbnail;
    public String caption;
    public String parse_mode;
    public List<MessageEntity> caption_entities;
    public boolean show_caption_above_media;
    public Integer width;
    public Integer height;
    public Integer duration;
    public boolean has_spoiler;
}
