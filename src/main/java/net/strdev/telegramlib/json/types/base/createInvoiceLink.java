package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class createInvoiceLink {
    public String business_connection_id;
    public String title;
    public String description;
    public String payload;
    public String provider_token;
    public String currency;
    public List<LabeledPrice> prices;
    public Integer subscription_period;
    public Integer max_tip_amount;
    public List<Integer> suggested_tip_amounts;
    public String provider_data;
    public String photo_url;
    public Integer photo_size;
    public Integer photo_width;
    public Integer photo_height;
    public boolean need_name;
    public boolean need_phone_number;
    public boolean need_email;
    public boolean need_shipping_address;
    public boolean send_phone_number_to_provider;
    public boolean send_email_to_provider;
    public boolean is_flexible;
}
