package Main.Controller;

import Main.Class.*;

public interface TokenControllerInterface {
    ReturnMSG summon(String TimeStamp, int amount, int value);

    ReturnMSG list(String user, String summoner, int type, int page);

    ReturnMSG use(String token);

    ReturnMSG remove(String token);

}
