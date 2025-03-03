package net.strdev.telegramlib.json.types.base;

public class ChatInviteLink {
    public String invite_link;
    public User creator;
    public boolean creates_join_request;
    public boolean is_primary;
    public boolean is_revoked;
    public String name;
    public Integer expire_date;
    public Integer member_limit;
    public Integer pending_join_request_count;
    public Integer subscription_period;
    public Integer subscription_price;
}
