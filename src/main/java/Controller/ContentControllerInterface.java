package Controller;

public interface ContentControllerInterface {
    void listCatalogue();

    void listCategory(String catalogue);

    void listEssay(String catalogue, String category, int page);

    void essay(String id);

    void modCatalogue(String key, String name, int index, String img);

    void modCategory(String catalogue, String key, String name, int index, String img);

    void uploadEssay(String catalogue, String category, String title, String avatar, String imgs, String content, String type);

    void lockEssay(String id, boolean lock);
}
