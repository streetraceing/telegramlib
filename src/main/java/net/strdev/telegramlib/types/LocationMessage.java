package net.strdev.telegramlib.types;

import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.json.types.Message;
import net.strdev.telegramlib.json.types.base.Location;
import net.strdev.telegramlib.types.scheme.MessageScheme;

public class LocationMessage extends MessageScheme {
    public Location location;

    public LocationMessage(Message message, Bot bot) {
        super(message, bot);
        this.location = message.location;
    }
}
