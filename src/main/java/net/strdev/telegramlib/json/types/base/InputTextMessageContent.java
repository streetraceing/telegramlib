package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class InputTextMessageContent {
    public String message_text;
    public String parse_mode;
    public List<MessageEntity> entities;
    public LinkPreviewOptions link_preview_options;
}
