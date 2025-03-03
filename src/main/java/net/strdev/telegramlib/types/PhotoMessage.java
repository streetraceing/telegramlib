package net.strdev.telegramlib.types;

import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.json.types.Message;
import net.strdev.telegramlib.json.types.base.PhotoSize;
import net.strdev.telegramlib.types.scheme.MessageScheme;

import java.util.List;

public class PhotoMessage extends MessageScheme {
    public String caption;
    public List<PhotoSize> photo;

    public PhotoMessage (Message message, Bot bot) {
        super(message, bot);
        this.caption = message.caption;
        this.photo = message.photo;
    }
}
