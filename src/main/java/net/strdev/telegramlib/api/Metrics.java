package net.strdev.telegramlib.api;

import net.strdev.telegramlib.utils.Logging;

public class Metrics {
    private long startTime;
    private boolean log = false;

    public Metrics() {
        this.startTime = System.currentTimeMillis();
    }

    public void debug() {
        this.log = true;
    }

    public void handle(String operation) {
        if (this.log) {
            printElapsedTime(operation);
        }
        updateStartTime();
    }

    public void updateStartTime() {
        this.startTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - this.startTime;
    }

    public void printElapsedTime(String operation) {
        Logging.log("Metrics", String.format("Elapsed time for \"%s\": %d ms.", operation, getElapsedTime()));
    }
}
