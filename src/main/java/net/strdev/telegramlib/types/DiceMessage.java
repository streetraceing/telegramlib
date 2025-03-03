package net.strdev.telegramlib.types;

import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.json.types.Message;
import net.strdev.telegramlib.json.types.base.Dice;
import net.strdev.telegramlib.types.scheme.MessageScheme;

public class DiceMessage extends MessageScheme {
    public Dice dice;

    public DiceMessage(Message message, Bot bot) {
        super(message, bot);
        this.dice = message.dice;
    }
}
