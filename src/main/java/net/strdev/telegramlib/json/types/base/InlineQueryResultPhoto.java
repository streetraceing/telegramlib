package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class InlineQueryResultPhoto {
    public String type;
    public String id;
    public String photo_url;
    public String thumbnail_url;
    public Integer photo_width;
    public Integer photo_height;
    public String title;
    public String description;
    public String caption;
    public String parse_mode;
    public List<MessageEntity> caption_entities;
    public boolean show_caption_above_media;
    public InlineKeyboardMarkup reply_markup;
    public InputMessageContent input_message_content;
}
