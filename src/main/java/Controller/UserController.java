package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController implements UserControllerInterface {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }


    @Override
    public void login(String username, String password, long time) {

    }

    @Override
    public void salt(String salt, String time) {

    }

    @Override
    public void logout() {

    }

    @Override
    public void register(String username, String password, String email, String code) {

    }
}