package net.strdev.telegramlib.api;

import net.strdev.telegramlib.events.EventManager;
import net.strdev.telegramlib.events.EventType;
import net.strdev.telegramlib.json.types.Update;
import net.strdev.telegramlib.json.types.Updates;
import net.strdev.telegramlib.network.TelegramException;
import net.strdev.telegramlib.types.*;
import net.strdev.telegramlib.utils.Logging;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Polling {
    protected Integer offset;
    protected Bot bot;
    protected Thread thread;
    public Metrics metrics;

    public Polling (Bot bot) {
        this.offset = 0;
        this.bot = bot;
        this.thread = null;
        this.metrics = new Metrics();
    }

    protected void poll() {
        try {
            Updates response = Bot.requests.getUpdates(offset);
            if(response.result == null || response.result.isEmpty()) {
                Logging.warn("Polling", "Update response is empty.");
                return;
            };
            if(!response.ok) {
                TelegramException e = new TelegramException(response.error_code, response.description);
                e.printStackTrace();
                throw e;
            }

            int index = response.result.size() - 1;
            offset = response.result.get(index).update_id + 1;
            Update update = response.result.get(index);

            //Logging.log("Updates", "Catched update #" + (offset-1));
            metrics.updateStartTime();

            // If event instance of message
            if(update.message != null) {
                Arrays.asList(update.message.getClass().getDeclaredFields()).forEach(f -> {
                    try {
                        if(f.get(update.message) != null) {
                            switch (f.getName()) {
                                case "text":
                                    if(update.message.entities != null && update.message.text.startsWith("/")) {
                                        if(update.message.entities.get(0).type.equals("bot_command")) {
                                            EventManager.throwEvent(EventType.COMMAND, new TextMessage(update.message, bot), bot);
                                            metrics.handle("Command Event");
                                            return;
                                        }
                                    }
                                    EventManager.throwEvent(EventType.MESSAGE, new TextMessage(update.message, bot), bot);
                                    metrics.handle("TextMessage Event");
                                    return;
                                case "photo":
                                    EventManager.throwEvent(EventType.PHOTO, new PhotoMessage(update.message, bot), bot);
                                    metrics.handle("PhotoMessage Event");
                                    return;
                                case "video":
                                    EventManager.throwEvent(EventType.VIDEO, new VideoMessage(update.message, bot), bot);
                                    metrics.handle("VideoMessage Event");
                                    return;
                                case "location":
                                    EventManager.throwEvent(EventType.LOCATION, new LocationMessage(update.message, bot), bot);
                                    metrics.handle("LocationMessage Event");
                                    return;
                                case "document":
                                    EventManager.throwEvent(EventType.DOCUMENT, new DocumentMessage(update.message, bot), bot);
                                    metrics.handle("DocumentMessage Event");
                                    return;
                                case "poll":
                                    EventManager.throwEvent(EventType.POLL, new PollMessage(update.message, bot), bot);
                                    metrics.handle("PollMessage Event");
                                    return;
                                case "audio":
                                    EventManager.throwEvent(EventType.AUDIO, new AudioMessage(update.message, bot), bot);
                                    metrics.handle("AudioMessage Event");
                                    return;
                                case "sticker":
                                    EventManager.throwEvent(EventType.STICKER, new StickerMessage(update.message, bot), bot);
                                    metrics.handle("StickerMessage Event");
                                    return;
                                case "animation":
                                    EventManager.throwEvent(EventType.ANIMATION, new AnimationMessage(update.message, bot), bot);
                                    metrics.handle("AnimationMessage Event");
                                    return;
                                case "dice":
                                    EventManager.throwEvent(EventType.DICE, new DiceMessage(update.message, bot), bot);
                                    metrics.handle("DiceMessage Event");
                                    return;
                            }
                        }
                    } catch (IllegalAccessException e) { System.out.println(e.getMessage()); }
                });
            // In other
            } else {
                Arrays.asList(update.getClass().getDeclaredFields()).forEach(f -> {
                    try {
                        if(f.get(update) != null) {
                            switch (f.getName()) {
                                case "edited_message":
                                    EventManager.throwEvent(EventType.EDITED_MESSAGE, new EditedMessageEvent(update.edited_message), bot);
                                    metrics.handle("EditedMessage Event");
                                    return;
                                case "callback_query":
                                    EventManager.throwEvent(EventType.CALLBACK_QUERY, new CallbackQueryEvent(update.callback_query), bot);
                                    metrics.handle("CallbackQuery Event");
                                    return;
                            }
                        }
                    } catch (IllegalAccessException e) {
                        Logging.warn("Polling", e.getMessage());
                    }
                });
            }
        } catch (Exception ignored) {}
    }

    protected void start() {
        if(thread == null) {
            thread = new Thread(() -> {
                ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
                executor.scheduleAtFixedRate(this::poll, 0L, 1L, TimeUnit.MILLISECONDS);
            });
            thread.start();
        }
    }
}
