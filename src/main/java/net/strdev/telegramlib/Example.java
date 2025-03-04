package net.strdev.telegramlib;

import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.commands.CommandHandler;
import net.strdev.telegramlib.requests.sendMessage;
import net.strdev.telegramlib.types.serializable.ReplyKeyboardRemove;

public class Example {
    public static void main(String[] args) {
        String token = args[0];
        Bot bot = new Bot(token);

        bot.onCommand(new CommandHandler("remove_keyboard", response -> {
            bot.sendRequest(
                    new sendMessage().chat_id(response.chat.id).text("Удаляем клавиатуру...")
                    .reply_markup(new ReplyKeyboardRemove())
            );
        }));
    }
}
