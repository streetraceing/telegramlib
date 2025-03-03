package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class GiveawayWinners {
    public Chat chat;
    public Integer giveaway_message_id;
    public Integer winners_selection_date;
    public Integer winner_count;
    public List<User> winners;
    public Integer additional_chat_count;
    public Integer prize_star_count;
    public Integer premium_subscription_month_count;
    public Integer unclaimed_prize_count;
    public boolean only_new_members;
    public boolean was_refunded;
    public String prize_description;
}
