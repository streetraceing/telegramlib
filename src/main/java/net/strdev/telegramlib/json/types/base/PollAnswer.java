package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class PollAnswer {
    public String poll_id;
    public Chat voter_chat;
    public User user;
    public List<Integer> option_ids;
}
