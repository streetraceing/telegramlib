package net.strdev.telegramlib.types;

import net.strdev.telegramlib.json.types.ForwardedMessage;
import net.strdev.telegramlib.json.types.base.CallbackQuery;
import net.strdev.telegramlib.json.types.base.MaybeInaccessibleMessage;
import net.strdev.telegramlib.json.types.base.User;

public class CallbackQueryEvent {
    public String id;
    public User user;
    public ForwardedMessage message;
    public MaybeInaccessibleMessage inaccessibleMessage;
    public String inline_message_id;
    public String chat_instance;
    public String data;
    public String game_short_name;

    public CallbackQueryEvent(CallbackQuery query) {
        this.id = query.id;
        this.user = query.from;
        this.chat_instance = query.chat_instance;
        this.data = query.data;
        this.game_short_name = query.game_short_name;
        this.inline_message_id = query.inline_message_id;
        try {
            this.message = query.message;
        } catch (Exception e) {
            e.printStackTrace();
            this.inaccessibleMessage = query.message;
        }
    }
}
