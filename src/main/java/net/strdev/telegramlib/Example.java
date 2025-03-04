package net.strdev.telegramlib;

import net.strdev.telegramlib.api.Bot;

public class Example {
    public static void main(String[] args) {
        String token = args[0];
        Bot bot = new Bot(token);
    }
}
