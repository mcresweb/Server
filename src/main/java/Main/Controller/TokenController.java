package Main.Controller;



import Main.Class.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class TokenController implements TokenControllerInterface {

    @RequestMapping("token/")
    @Override
    public ReturnMSG summon(@RequestParam String TimeStamp, @RequestParam int amount,@RequestParam int value) {
        return null;
    }

    @Override
    public ReturnMSG list(String user, String summoner, int type, int page) {
        return null;
    }

    @Override
    public ReturnMSG use(String token) {
        return null;
    }

    @Override
    public ReturnMSG remove(String token) {
        return null;
    }
}
