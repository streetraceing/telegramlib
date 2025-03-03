package net.strdev.telegramlib.types;

import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.json.types.Message;
import net.strdev.telegramlib.json.types.base.Document;
import net.strdev.telegramlib.types.scheme.MessageScheme;

public class DocumentMessage extends MessageScheme {
    public Document document;
    public String caption;

    public DocumentMessage(Message message, Bot bot) {
        super(message, bot);
        this.document = message.document;
        this.caption = message.caption;
    }
}
