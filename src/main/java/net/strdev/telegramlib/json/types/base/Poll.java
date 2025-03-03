package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class Poll {
    public String id;
    public String question;
    public List<MessageEntity> question_entities;
    public List<PollOption> options;
    public Integer total_voter_count;
    public boolean is_closed;
    public boolean is_anonymous;
    public String type;
    public boolean allows_multiple_answers;
    public Integer correct_option_id;
    public String explanation;
    public List<MessageEntity> explanation_entities;
    public Integer open_period;
    public Integer close_date;
}
