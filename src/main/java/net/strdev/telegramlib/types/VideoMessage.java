package net.strdev.telegramlib.types;

import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.json.types.Message;
import net.strdev.telegramlib.json.types.base.Video;
import net.strdev.telegramlib.types.scheme.MessageScheme;

public class VideoMessage extends MessageScheme {
    public Video video;
    public String caption;

    public VideoMessage (Message message, Bot bot) {
        super(message, bot);
        this.video = message.video;
        this.caption = message.caption;
    }
}
