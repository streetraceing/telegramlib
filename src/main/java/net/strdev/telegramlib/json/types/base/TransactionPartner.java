package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class TransactionPartner {
    public String type;
    public User user;
    public AffiliateInfo affiliate;
    public String invoice_payload;
    public Integer subscription_period;
    public List<PaidMedia> paid_media;
    public String paid_media_payload;
    public Gift gift;
}
