package net.strdev.telegramlib.events;

import net.strdev.telegramlib.api.Bot;
import net.strdev.telegramlib.commands.CommandResponse;
import net.strdev.telegramlib.types.TextMessage;
import net.strdev.telegramlib.utils.Logging;
import net.strdev.telegramlib.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class EventManager {
    private static final List<Event> events = new ArrayList<>();

    public static void registerEvent(EventType event, Consumer callback, Bot bot, Condition... optional) {
        events.add(new Event(callback, event, bot, optional));
        Logging.log("EventManager", "Registered new " + event.name() + " event");
    }

    public static void removeEvent(EventType event, Condition... optional) {
        if(optional.length > 0) {
            events.removeAll(
                    events.stream().filter(e ->
                            (e.event == event) &&
                            (optional[0].equals(e.optional[0])))
                    .collect(Collectors.toList())
            );
            Logging.log("EventManager", "Removed all " + event.name() + " events with condition " + optional[0]);
        } else {
            events.removeAll(events.stream().filter(e -> e.event == event).collect(Collectors.toList()));
            Logging.log("EventManager", "Removed all " + event.name() + " events");
        }
    }

    public static void throwEvent(EventType event, Object data, Bot bot) {
        events.stream().filter(e -> e.bot == bot && e.event == event).forEach(e -> {
            if (e.optional.length > 0) {
                Condition condition = e.optional[0];

                switch (condition.name) {
                    case "command":
                        TextMessage textMessage = (TextMessage) data;
                        String[] args = new String[0];

                        if(StringUtils.trimStart(textMessage.text, condition.value.length()+1).equals("/"+condition.value)) {
                            if(textMessage.text.length() >= (condition.value.length()+2)) {
                                args = textMessage.text.substring(condition.value.length()+2).split(" ");
                            }

                            CommandResponse commandResponse = new CommandResponse(
                                    textMessage.message_id, textMessage.date, textMessage.chat, textMessage.from, args, e.bot
                            );

                            Logging.log("EventManager", "Event " + event.name() + " throwed with condition " + condition.name + "=" + condition.value);
                            e.active(commandResponse);
                        }
                        return;
                    case "keyboard":
                        return;
                }
            }
            else {
                Logging.log("EventManager", "Event " + event.name() + " throwed");
                e.active(data);
            }
        });
    }
}
