package net.strdev.telegramlib;

import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.requests.sendMessage;

public class Main {
    public static void main(String[] args) {
        String token = args[0];
        Bot bot = new Bot(token);

        int target_user_id = 0;
        String text = "Message";

        bot.sendRequest(
                new sendMessage()
                        .chat_id(0)
                        .text(text)
        );
    }
}
