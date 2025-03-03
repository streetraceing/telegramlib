package net.strdev.telegramlib.types;

import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.json.types.Message;
import net.strdev.telegramlib.json.types.base.Sticker;
import net.strdev.telegramlib.types.scheme.MessageScheme;

public class StickerMessage extends MessageScheme {
    public Sticker sticker;

    public StickerMessage (Message message, Bot bot) {
        super(message, bot);
        this.sticker = message.sticker;
    }
}
