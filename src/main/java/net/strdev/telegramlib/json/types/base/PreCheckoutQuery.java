package net.strdev.telegramlib.json.types.base;

public class PreCheckoutQuery {
    public String id;
    public User from;
    public String currency;
    public Integer total_amount;
    public String invoice_payload;
    public String shipping_option_id;
    public OrderInfo order_info;
}
