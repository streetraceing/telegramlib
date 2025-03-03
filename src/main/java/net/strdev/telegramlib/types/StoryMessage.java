package net.strdev.telegramlib.types;

import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.json.types.Message;
import net.strdev.telegramlib.json.types.base.Story;
import net.strdev.telegramlib.types.scheme.MessageScheme;

public class StoryMessage extends MessageScheme {
    public Story story;

    public StoryMessage(Message message, Bot bot) {
        super(message, bot);
        this.story = message.story;
    }
}
