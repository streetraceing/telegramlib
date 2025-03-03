package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class Game {
    public String title;
    public String description;
    public List<PhotoSize> photo;
    public String text;
    public List<MessageEntity> text_entities;
    public Animation animation;
}
