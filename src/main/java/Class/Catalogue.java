package Class;

import java.util.concurrent.ConcurrentHashMap;

public class Catalogue {
    /**
     *  此大类的标题
     */
    public String title;
    /**
     *  此大类的图片
     */
    public byte[] image;
    /**
     *  此大类的ID
     */
    public String id;
    /**
     *  此大类所拥有的所有小类 键为ID 值为名称
     */
    public ConcurrentHashMap<String, String> categories;

    public Catalogue(String title, byte[] image, String id, ConcurrentHashMap<String, String> categories) {
        this.title = title;
        this.image = image;
        this.id = id;
        this.categories = categories;
    }

   
}
