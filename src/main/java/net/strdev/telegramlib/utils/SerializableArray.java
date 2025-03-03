package net.strdev.telegramlib.utils;

import java.util.Arrays;
import java.util.List;

public class SerializableArray {
    private Object[] values;

    public SerializableArray(Object... values) {
        this.values = values;
    }

    public List<Object> values() {
        return Arrays.asList(values);
    }

    public static List<Object> from(Object... values) {
        return Arrays.asList(values);
    }
}
