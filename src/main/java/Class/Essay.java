package Class;

import java.awt.*;
import java.util.ArrayList;

public class Essay {
    public String id;
    public String senderId;
    public String categoryId;
    public String catalogueId;
    public String title;
    public String content;
    public String type;
    public ArrayList<String> image;

    public Essay(String id, String senderId, String categoryId, String catalogueId, String title, String content, String type, ArrayList<String> image) {
        this.id = id;
        this.senderId = senderId;
        this.categoryId = categoryId;
        this.catalogueId = catalogueId;
        this.title = title;
        this.content = content;
        this.type = type;
        this.image = image;
    }
}
