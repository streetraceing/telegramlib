package net.strdev.telegramlib.types;

import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.json.types.Message;
import net.strdev.telegramlib.json.types.base.Animation;
import net.strdev.telegramlib.types.scheme.MessageScheme;

public class AnimationMessage extends MessageScheme {
    public Animation animation;
    public String caption;

    public AnimationMessage(Message message, Bot bot) {
        super(message, bot);
        this.animation = message.animation;
        this.caption = message.caption;
    }
}
