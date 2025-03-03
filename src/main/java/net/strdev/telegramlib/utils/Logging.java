package net.strdev.telegramlib.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logging {
    private static boolean debugging = false;
    private static DebugLevel debugLevel = DebugLevel.ALL;

    private static String getTime() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(date);
    }

    public static void debug(DebugLevel value) {
        debugging = true;
        debugLevel = value;
    }

    public static void log(String module, String message) {
        if(debugging && debugLevel.value >= DebugLevel.ALL.value) {
            System.out.printf("[%s * %s] %s%n", getTime(), module, message);
        }
    }

    public static void warn(String module, String message) {
        if(debugging && debugLevel.value >= DebugLevel.WARN.value) {
            System.out.printf("[WARN] [%s * %s] %s%n", getTime(), module, message);
        }
    }
}
