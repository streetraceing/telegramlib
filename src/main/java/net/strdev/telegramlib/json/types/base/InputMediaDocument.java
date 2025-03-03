package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class InputMediaDocument {
    public String type;
    public String media;
    public String thumbnail;
    public String caption;
    public String parse_mode;
    public List<MessageEntity> caption_entities;
    public boolean disable_content_type_detection;
}
