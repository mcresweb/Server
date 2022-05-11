package Class;

import java.util.concurrent.ConcurrentHashMap;

public class Category {
    /**
     * 此小类的ID
     */
    private String id;
    /**
     *  标题
     */
    private String title;

    /**
     *  图片
     */
    private byte[] image;

    /**
     *  所有的 内容 key为ID 值为标题
     */
    private ConcurrentHashMap<String, String> essays;

    public Category(String id, String title, byte[] image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public ConcurrentHashMap<String, String> getEssays() {
        return essays;
    }

    public void setEssays(ConcurrentHashMap<String, String> essays) {
        this.essays = essays;
    }
}
