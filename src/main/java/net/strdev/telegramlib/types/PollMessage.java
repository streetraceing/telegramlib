package net.strdev.telegramlib.types;

import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.json.types.Message;
import net.strdev.telegramlib.json.types.base.Poll;
import net.strdev.telegramlib.types.scheme.MessageScheme;

public class PollMessage extends MessageScheme {
    public Poll poll;

    public PollMessage(Message message, Bot bot) {
        super(message, bot);
        this.poll = message.poll;
    }
}
