package net.strdev.telegramlib.api;

import net.strdev.telegramlib.commands.CommandHandler;
import net.strdev.telegramlib.events.Condition;
import net.strdev.telegramlib.events.EventManager;
import net.strdev.telegramlib.events.EventType;
import net.strdev.telegramlib.network.Requests;
import net.strdev.telegramlib.network.TelegramRequest;
import net.strdev.telegramlib.requests.deleteMessage;
import net.strdev.telegramlib.requests.editMessageText;
import net.strdev.telegramlib.requests.sendMessage;
import net.strdev.telegramlib.requests.setMessageReaction;
import net.strdev.telegramlib.types.*;
import net.strdev.telegramlib.types.serializable.ReactionType;
import net.strdev.telegramlib.types.serializable.ReplyParameters;
import net.strdev.telegramlib.utils.DebugLevel;
import net.strdev.telegramlib.utils.Logging;

import java.util.function.Consumer;

public class Bot {
    protected String token;
    protected Polling polling;
    protected static Requests requests;

    public Bot (String token) {
        this.token = token;
        this.polling = new Polling(this);
        this.polling.start();
        requests = new Requests(token);
    }

    public void debug(DebugLevel level) {
        this.polling.metrics.debug();
        Logging.debug(level);

        Logging.log("Bot", "Debugger is active.");
    }

    // Default methods

    public void editTextMessage(long chat_id, Integer message_id, String text) {
        sendRequest(new editMessageText().chat_id(chat_id).message_id(message_id).text(text));
    }

    public void editTextMessage(String chat_id, Integer message_id, String text) {
        sendRequest(new editMessageText().chat_id(chat_id).message_id(message_id).text(text));
    }

    public void deleteMessage(long chat_id, Integer message_id) {
        sendRequest(new deleteMessage().chat_id(chat_id).message_id(message_id));
    }

    public void deleteMessage(String chat_id, Integer message_id) {
        sendRequest(new deleteMessage().chat_id(chat_id).message_id(message_id));
    }

    public void replyMessageText(long chat_id, Integer message_id, String text) {
        sendRequest(new sendMessage().chat_id(chat_id).text(text).reply_parameters(new ReplyParameters(message_id)));
    }

    public void replyMessageText(String chat_id, Integer message_id, String text) {
        sendRequest(new sendMessage().chat_id(chat_id).text(text).reply_parameters(new ReplyParameters(message_id)));
    }

    public void addReaction(long chat_id, Integer message_id, String emoji) {
        sendRequest(new setMessageReaction().chat_id(chat_id).message_id(message_id).reaction(new ReactionType().emoji(emoji)));
    }

    public void addReaction(String chat_id, Integer message_id, String emoji) {
        sendRequest(new setMessageReaction().chat_id(chat_id).message_id(message_id).reaction(new ReactionType().emoji(emoji)));
    }

    public void sendText(String text, long chat_id) {
        sendRequest(new sendMessage().chat_id(chat_id).text(text));
    }

    public void sendText(String text, String chat_id) {
        sendRequest(new sendMessage().chat_id(chat_id).text(text));
    }

    // Advanced methods

    public void sendRequest(TelegramRequest request) {
        requests.sendRequest(request.setToken(this.token));
    }

    // Events

    public void onText(Consumer<TextMessage> callback) {
        EventManager.registerEvent(EventType.MESSAGE, callback, this);
    }

    public void onCommand(CommandHandler handler) {
        EventManager.registerEvent(EventType.COMMAND, handler.callback, this, new Condition("command", handler.command));
    }

    public void onEdit(Consumer<EditedMessageEvent> callback) {
        EventManager.registerEvent(EventType.EDITED_MESSAGE, callback, this);
    }

    public void onPhoto(Consumer<PhotoMessage> callback) {
        EventManager.registerEvent(EventType.PHOTO, callback, this);
    }

    public void onSticker(Consumer<StickerMessage> callback) {
        EventManager.registerEvent(EventType.STICKER, callback, this);
    }

    public void onAudio(Consumer<AudioMessage> callback) {
        EventManager.registerEvent(EventType.AUDIO, callback, this);
    }

    public void onVideo(Consumer<VideoMessage> callback) {
        EventManager.registerEvent(EventType.VIDEO, callback, this);
    }

    public void onPoll(Consumer<PollMessage> callback) {
        EventManager.registerEvent(EventType.POLL, callback, this);
    }

    public void onLocation(Consumer<LocationMessage> callback) {
        EventManager.registerEvent(EventType.LOCATION, callback, this);
    }

    public void onDocument(Consumer<DocumentMessage> callback) {
        EventManager.registerEvent(EventType.DOCUMENT, callback, this);
    }

    public void onContact(Consumer<ContactMessage> callback) {
        EventManager.registerEvent(EventType.CONTACT, callback, this);
    }

    public void onStory(Consumer<StoryMessage> callback) {
        EventManager.registerEvent(EventType.STORY, callback, this);
    }

    public void onVoice(Consumer<VoiceMessage> callback) {
        EventManager.registerEvent(EventType.VOICE, callback, this);
    }

    public void onAnimation(Consumer<AnimationMessage> callback) {
        EventManager.registerEvent(EventType.ANIMATION, callback, this);
    }

    public void onDice(Consumer<DiceMessage> callback) {
        EventManager.registerEvent(EventType.DICE, callback, this);
    }

    public void onCallbackQuery(Consumer<CallbackQueryEvent> callback) {
        EventManager.registerEvent(EventType.CALLBACK_QUERY, callback, this);
    }
}
