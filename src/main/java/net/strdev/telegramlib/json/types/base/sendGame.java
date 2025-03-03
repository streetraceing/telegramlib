package net.strdev.telegramlib.json.types.base;

public class sendGame {
    public String business_connection_id;
    public Integer chat_id;
    public Integer message_thread_id;
    public String game_short_name;
    public boolean disable_notification;
    public boolean protect_content;
    public boolean allow_paid_broadcast;
    public String message_effect_id;
    public ReplyParameters reply_parameters;
    public InlineKeyboardMarkup reply_markup;
}
