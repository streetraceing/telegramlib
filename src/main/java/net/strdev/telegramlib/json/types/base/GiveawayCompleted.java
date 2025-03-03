package net.strdev.telegramlib.json.types.base;

import net.strdev.telegramlib.json.types.Message;

public class GiveawayCompleted {
    public Integer winner_count;
    public Integer unclaimed_prize_count;
    public Message giveaway_message;
    public boolean is_star_giveaway;
}
