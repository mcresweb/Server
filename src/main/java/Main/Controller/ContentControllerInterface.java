package Main.Controller;
import Main.Class.*;
public interface ContentControllerInterface {
    ReturnMSG listCatalogue();

    ReturnMSG listCategory(String catalogue);

    ReturnMSG listEssay(String catalogue, String category, int page);

    ReturnMSG essay(String id);

    ReturnMSG modCatalogue(String key, String name, int index, String img);

    ReturnMSG modCategory(String catalogue, String key, String name, int index, String img);

    ReturnMSG uploadEssay(String catalogue, String category, String title, String avatar, String imgs, String content, String type);

    ReturnMSG lockEssay(String id, boolean lock);
}
