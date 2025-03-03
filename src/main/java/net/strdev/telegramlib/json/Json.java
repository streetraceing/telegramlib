package net.strdev.telegramlib.json;

import com.google.gson.Gson;
import net.strdev.telegramlib.json.types.Response;
import net.strdev.telegramlib.json.types.Updates;

public class Json {
    public static final Gson parser = new Gson();

    public static Updates parseUpdates(String json) {
        return parser.fromJson(json, Updates.class);
    }

    public static Response parseResponse(String json) {
        return parser.fromJson(json, Response.class);
    }
}
