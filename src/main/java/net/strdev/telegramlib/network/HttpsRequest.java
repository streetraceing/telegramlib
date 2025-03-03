package net.strdev.telegramlib.network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class HttpsRequest {
    private final List<String> options = new ArrayList<>();
    private final HashMap<String, Object> query = new HashMap<>();

    public HttpsRequest(String site) {
        options.add("https://");
        options.add(site);
    }

    public HttpsRequest addPath(String path) {
        options.add("/" + path);
        return this;
    }

    public HttpsRequest addQuery(String param, Object value) {
        query.put(param, value);
        return this;
    }

    public String asString() {
        if(!query.entrySet().isEmpty()) {
            options.add("?");
            options.add(
                query.entrySet()
                        .stream()
                        .map(e -> e.getKey()+"="+e.getValue())
                        .collect(Collectors.joining("&"))
            );
        }
        return String.join("", options);
    }
}
