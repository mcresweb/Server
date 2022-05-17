package Main.Controller;
import Main.Class.*;
public interface ImgControllerInterface {
    ReturnMSG upload(String id, String targetId, String content, String target);

    ReturnMSG list(String target, String targetId);

    ReturnMSG get(String id);

    ReturnMSG remove(String id);
}
