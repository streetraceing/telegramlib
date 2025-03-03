package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class InlineQueryResultDocument {
    public String type;
    public String id;
    public String title;
    public String caption;
    public String parse_mode;
    public List<MessageEntity> caption_entities;
    public String document_url;
    public String mime_type;
    public String description;
    public InlineKeyboardMarkup reply_markup;
    public InputMessageContent input_message_content;
    public String thumbnail_url;
    public Integer thumbnail_width;
    public Integer thumbnail_height;
}
