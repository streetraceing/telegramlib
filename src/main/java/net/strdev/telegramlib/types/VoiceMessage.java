package net.strdev.telegramlib.types;

import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.json.types.Message;
import net.strdev.telegramlib.json.types.base.Voice;
import net.strdev.telegramlib.types.scheme.MessageScheme;

public class VoiceMessage extends MessageScheme {
    public Voice voice;
    public String caption;

    public VoiceMessage(Message message, Bot bot) {
        super(message, bot);
        this.voice = message.voice;
        this.caption = message.caption;
    }
}
