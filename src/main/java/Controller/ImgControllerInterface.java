package Controller;

public interface ImgControllerInterface {
    void upload(String id, String targetId, String content, String target);

    void list(String target, String targetId);

    void get(String id);

    void remove(String id);
}
