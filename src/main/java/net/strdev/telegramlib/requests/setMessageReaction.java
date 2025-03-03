package net.strdev.telegramlib.requests;

import net.strdev.telegramlib.network.TelegramRequest;
import net.strdev.telegramlib.types.serializable.ReactionType;

public class setMessageReaction extends TelegramRequest {
    public setMessageReaction(String token) {
        super(token, "setMessageReaction");
    }

    public setMessageReaction() {
        super("setMessageReaction");
    }

    public setMessageReaction chat_id(long value) {
        addQuery("chat_id", value);
        return this;
    }

    public setMessageReaction chat_id(String value) {
        addQuery("chat_id", value);
        return this;
    }

    public setMessageReaction message_id(int value) {
        addQuery("message_id", value);
        return this;
    }

    public setMessageReaction is_big(boolean value) {
        addQuery("is_big", value);
        return this;
    }

    public setMessageReaction reaction(ReactionType value) {
        addQuery("reaction", value.asString());
        return this;
    }
}
