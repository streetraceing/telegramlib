package net.strdev.telegramlib.types.serializable.base;

import net.strdev.telegramlib.json.Json;

import java.util.ArrayList;
import java.util.List;

public class TelegramArray {
    private final List<Object> parameters = new ArrayList<>();

    public void add(Object value) {
        parameters.add(value);
    }

    public List<Object> asList() {
        return parameters;
    }

    public String asString() {
        return Json.parser.toJson(parameters);
    }
}
