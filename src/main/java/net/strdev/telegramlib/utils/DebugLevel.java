package net.strdev.telegramlib.utils;

public enum DebugLevel {
    ALL (0),
    WARN (1);

    public final int value;

    DebugLevel(int level) {
        this.value = level;
    }
}
