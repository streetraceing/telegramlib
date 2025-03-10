package net.strdev.telegramlib.network;

import net.strdev.telegramlib.api.Metrics;
import net.strdev.telegramlib.json.Json;
import net.strdev.telegramlib.json.types.Response;
import net.strdev.telegramlib.json.types.Updates;
import net.strdev.telegramlib.requests.getUpdates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public final class Requests {
    private final String token;
    public static Metrics metrics = new Metrics();

    public Requests(String token) {
        this.token = token;
    }

    public static String get(HttpsRequest request) {
        metrics.updateStartTime();
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(request.asString());
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            BufferedReader reader;

            if(connection.getResponseCode() == 200) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                reader.lines().forEach(response::append);
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            reader.lines().forEach(response::append);
            metrics.handle("Get Request");
            return response.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public String sendRequest(HttpsRequest request) {
        String res = get(request);
        Response response = Json.parseResponse(res);
        if(!response.ok) {
            TelegramException e = new TelegramException(response.error_code, response.description);
            System.out.println(e.getMessage());
            throw e;
        }
        return res;
    }

    public Updates getUpdates(Integer offset) {
        return Json.parseUpdates(get(new getUpdates(token).offset(offset)));
    }
}