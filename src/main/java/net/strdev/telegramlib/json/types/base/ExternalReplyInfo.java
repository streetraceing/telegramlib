package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class ExternalReplyInfo {
    public MessageOrigin origin;
    public Chat chat;
    public Integer message_id;
    public LinkPreviewOptions link_preview_options;
    public Animation animation;
    public Audio audio;
    public Document document;
    public PaidMediaInfo paid_media;
    public List<PhotoSize> photo;
    public Sticker sticker;
    public Story story;
    public Video video;
    public VideoNote video_note;
    public Voice voice;
    public boolean has_media_spoiler;
    public Contact contact;
    public Dice dice;
    public Game game;
    public Giveaway giveaway;
    public GiveawayWinners giveaway_winners;
    public Invoice invoice;
    public Location location;
    public Poll poll;
    public Venue venue;
}
