package net.strdev.telegramlib.events;

import net.strdev.telegramlib.api.Bot;

import java.util.function.Consumer;

public class Event {
    public Consumer consumer;
    public EventType event;
    public Bot bot;
    public Condition[] optional;

    public Event (Consumer consumer, EventType event, Bot bot, Condition... optional) {
        this.consumer = consumer;
        this.event = event;
        this.bot = bot;
        this.optional = optional;
    }

    public void active(Object data) {
        this.consumer.accept(data);
    }
}
