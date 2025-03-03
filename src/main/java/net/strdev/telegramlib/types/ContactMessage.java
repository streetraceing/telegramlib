package net.strdev.telegramlib.types;

import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.json.types.Message;
import net.strdev.telegramlib.json.types.base.Contact;
import net.strdev.telegramlib.types.scheme.MessageScheme;

public class ContactMessage extends MessageScheme {
    public Contact contact;

    public ContactMessage(Message message, Bot bot) {
        super(message, bot);
        this.contact = message.contact;
    }
}
