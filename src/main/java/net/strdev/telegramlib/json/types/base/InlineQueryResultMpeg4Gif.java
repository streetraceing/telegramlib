package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class InlineQueryResultMpeg4Gif {
    public String type;
    public String id;
    public String mpeg4_url;
    public Integer mpeg4_width;
    public Integer mpeg4_height;
    public Integer mpeg4_duration;
    public String thumbnail_url;
    public String thumbnail_mime_type;
    public String title;
    public String caption;
    public String parse_mode;
    public List<MessageEntity> caption_entities;
    public boolean show_caption_above_media;
    public InlineKeyboardMarkup reply_markup;
    public InputMessageContent input_message_content;
}
