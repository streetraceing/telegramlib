package net.strdev.telegramlib.network;

public class TelegramRequest extends HttpsRequest {
    private String tempMethod;

    public TelegramRequest(String token, String method) {
        super("api.telegram.org");
        this.addPath("bot" + token).addPath(method);
    }

    public TelegramRequest(String method) {
        super("api.telegram.org");
        this.tempMethod = method;
    }

    public TelegramRequest setToken(String token) {
        this.addPath("bot"+token);
        this.addPath(tempMethod);
        return this;
    }
}
