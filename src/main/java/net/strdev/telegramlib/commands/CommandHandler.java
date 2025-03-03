package net.strdev.telegramlib.commands;

import java.util.function.Consumer;

public class CommandHandler {
    public String command;
    public Consumer<CommandResponse> callback;

    public CommandHandler(String command, Consumer<CommandResponse> callback) {
        this.command = command;
        this.callback = callback;
    }
}
