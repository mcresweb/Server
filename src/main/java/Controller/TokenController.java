package Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class TokenController implements TokenControllerInterface {

    @RequestMapping("token/")
    @Override
    public void summon(@RequestParam String TimeStamp, @RequestParam int amount,@RequestParam int value) {

    }

    @Override
    public void list(String user, String summoner, int type, int page) {

    }

    @Override
    public void use(String token) {

    }

    @Override
    public void remove(String token) {

    }
}
