package net.strdev.telegramlib.utils;

public class StringUtils {
    public static String trimStart(String string, int count) {
        return string.length() > count ? string.substring(0, count) : string;
    }

    public static String trimEnd(String string, int count) {
        return string.length() > count ? string.substring(string.length() - count) : string;
    }
}
