package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class Giveaway {
    public List<Chat> chats;
    public Integer winners_selection_date;
    public Integer winner_count;
    public boolean only_new_members;
    public boolean has_public_winners;
    public String prize_description;
    public List<String> country_codes;
    public Integer prize_star_count;
    public Integer premium_subscription_month_count;
}
