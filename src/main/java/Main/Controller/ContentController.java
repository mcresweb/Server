package Main.Controller;

import Main.Class.*;

public class ContentController implements ContentControllerInterface {

    @Override
    public ReturnMSG listCatalogue() {
        return null;
    }

    @Override
    public ReturnMSG listCategory(String catalogue) {
        return null;
    }

    @Override
    public ReturnMSG listEssay(String catalogue, String category, int page) {
        return null;
    }

    @Override
    public ReturnMSG essay(String id) {
        return null;
    }

    @Override
    public ReturnMSG modCatalogue(String key, String name, int index, String img) {
        return null;
    }

    @Override
    public ReturnMSG modCategory(String catalogue, String key, String name, int index, String img) {
        return null;
    }

    @Override
    public ReturnMSG uploadEssay(String catalogue, String category, String title, String avatar, String imgs, String content, String type) {
        return null;
    }

    @Override
    public ReturnMSG lockEssay(String id, boolean lock) {
        return null;
    }
}
