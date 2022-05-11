package Class;

import java.util.concurrent.ConcurrentHashMap;

public class Catalogue {
    /**
     *  此大类的标题
     */
    private String title;
    /**
     *  此大类的图片
     */
    private byte[] image;
    /**
     *  此大类的ID
     */
    private String id;
    /**
     *  此大类所拥有的所有小类 键为ID 值为名称
     */
    private ConcurrentHashMap<String, String> categories;

    public Catalogue(String title, byte[] image, String id, ConcurrentHashMap<String, String> categories) {
        this.title = title;
        this.image = image;
        this.id = id;
        this.categories = categories;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ConcurrentHashMap<String, String> getCategories() {
        return categories;
    }

    public void setCategories(ConcurrentHashMap<String, String> categories) {
        this.categories = categories;
    }
}
