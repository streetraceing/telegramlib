package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class ReplyParameters {
    public Integer message_id;
    public String chat_id;
    public boolean allow_sending_without_reply;
    public String quote;
    public String quote_parse_mode;
    public List<MessageEntity> quote_entities;
    public Integer quote_position;

    public ReplyParameters() {

    }
}
