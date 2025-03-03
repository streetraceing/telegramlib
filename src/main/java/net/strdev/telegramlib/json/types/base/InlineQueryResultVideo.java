package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class InlineQueryResultVideo {
    public String type;
    public String id;
    public String video_url;
    public String mime_type;
    public String thumbnail_url;
    public String title;
    public String caption;
    public String parse_mode;
    public List<MessageEntity> caption_entities;
    public boolean show_caption_above_media;
    public Integer video_width;
    public Integer video_height;
    public Integer video_duration;
    public String description;
    public InlineKeyboardMarkup reply_markup;
    public InputMessageContent input_message_content;
}
