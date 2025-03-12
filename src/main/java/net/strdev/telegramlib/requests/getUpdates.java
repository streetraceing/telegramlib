package net.strdev.telegramlib.requests;

import net.strdev.telegramlib.json.Json;
import net.strdev.telegramlib.network.TelegramRequest;

import java.util.Arrays;

public class getUpdates extends TelegramRequest {
    public getUpdates(String token) {
        super(token, "getUpdates");
    }

    public getUpdates() {
        super("getUpdates");
    }

    public getUpdates offset(int value) {
        addQuery("offset", value);
        return this;
    }

    public getUpdates limit(int value) {
        addQuery("limit", value);
        return this;
    }

    public getUpdates timeout(int value) {
        addQuery("timeout", value);
        return this;
    }

    public getUpdates allowed_updates(String[] value) {
        addQuery("allowed_updates", Json.parser.toJson(Arrays.asList(value)));
        return this;
    }
}
