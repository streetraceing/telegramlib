package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class InlineQueryResultCachedAudio {
    public String type;
    public String id;
    public String audio_file_id;
    public String caption;
    public String parse_mode;
    public List<MessageEntity> caption_entities;
    public InlineKeyboardMarkup reply_markup;
    public InputMessageContent input_message_content;
}
