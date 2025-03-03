package net.strdev.telegramlib.json.types.base;

import java.util.List;

public class Video {
    public String file_id;
    public String file_unique_id;
    public Integer width;
    public Integer height;
    public Integer duration;
    public PhotoSize thumbnail;
    public List<PhotoSize> cover;
    public Integer start_timestamp;
    public String file_name;
    public String mime_type;
    public Integer file_size;
}
