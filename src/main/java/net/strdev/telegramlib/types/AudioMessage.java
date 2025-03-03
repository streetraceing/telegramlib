package net.strdev.telegramlib.types;

import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.json.types.Message;
import net.strdev.telegramlib.json.types.base.Audio;
import net.strdev.telegramlib.types.scheme.MessageScheme;

public class AudioMessage extends MessageScheme {
    public Audio audio;
    public String caption;

    public AudioMessage (Message message, Bot bot) {
        super(message, bot);
        this.audio = message.audio;
        this.caption = message.caption;
    }
}
