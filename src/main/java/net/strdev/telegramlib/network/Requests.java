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

    @Deprecated
    private static String get(HttpsRequest request) {
        StringBuilder response = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(request.asString()).openStream()));
            int c;
            while ((c = reader.read()) != -1) { response.append((char) c); }
            return response.toString();
        } catch (IOException e) {
            //System.out.println(e.getMessage());
        }
        return response.toString();
    }

    public static String getV2(HttpsRequest request) {
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
            metrics.handle("getV2 Request");
            return response.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public void sendRequest(HttpsRequest request) {
        Response response = Json.parseResponse(getV2(request));
        if(!response.ok) {
            TelegramException e = new TelegramException(response.error_code, response.description);
            e.printStackTrace();
            throw e;
        }
    }

    public Updates getUpdates(Integer offset) {
        return Json.parseUpdates(getV2(new getUpdates(token).offset(offset)));
    }
}