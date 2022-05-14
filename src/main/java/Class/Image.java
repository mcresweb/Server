package Class;

public class Image {

    public String id;
    public String content;
    public String target;//哪个地方用的图片
    public String targetId;

    public Image(String id, String content, String target, String targetId) {
        this.id = id;
        this.content = content;
        this.target = target;
        this.targetId = targetId;
    }
}
