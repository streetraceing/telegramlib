package net.strdev.telegramlib.json.types.base;

public class SuccessfulPayment {
    public String currency;
    public Integer total_amount;
    public String invoice_payload;
    public Integer subscription_expiration_date;
    public boolean is_recurring;
    public boolean is_first_recurring;
    public String shipping_option_id;
    public OrderInfo order_info;
    public String telegram_payment_charge_id;
    public String provider_payment_charge_id;
}
