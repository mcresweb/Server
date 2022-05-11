package Class;

import java.util.concurrent.ConcurrentHashMap;

public class Category {
    /**
     * 此小类的ID
     */
    public String id;
    /**
     *  标题
     */
    public String title;

    /**
     *  图片
     */
    public byte[] image;

    /**
     *  所有的 内容 key为ID 值为标题
     */
    public ConcurrentHashMap<String, String> essays;

    public Category(String id, String title, byte[] image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }

   
}
