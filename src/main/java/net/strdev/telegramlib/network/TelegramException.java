package net.strdev.telegramlib.network;

public class TelegramException extends RuntimeException {
    int error_code;
    String description;

    public TelegramException(int error_code, String description) {
        super("[Code " + error_code + "] " + description);
        this.error_code = error_code;
        this.description = description;
    }

    public int getErrorCode() {
        return error_code;
    }

    public String getDescription() {
        return description;
    }
}
