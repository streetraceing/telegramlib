package net.strdev.telegramlib.types.serializable.base;

import net.strdev.telegramlib.json.Json;

import java.util.HashMap;

public class TelegramSerializable {
    private final HashMap<String, Object> parameters = new HashMap<>();

    public void add(String name, Object value) {
        parameters.put(name, value);
    }

    public HashMap<String, Object> asMap() {
        return parameters;
    }

    public String asString() {
        return Json.parser.toJson(parameters);
    }
}
