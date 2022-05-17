package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController implements UserControllerInterface {
    @ResponseBody
    @RequestMapping("api/user/login")
    @Override
    public void login(String username, String password, long time) {

    }

    @ResponseBody
    @RequestMapping("api/user/salt")
    @Override
    public void salt(String salt, String time) {

    }

    @ResponseBody
    @RequestMapping("api/user/")
    @Override
    public void logout() {

    }

    @ResponseBody
    @RequestMapping("api/user/register")
    @Override
    public void register(String username, String password, String email, String code) {

    }

    @ResponseBody
    @RequestMapping("api/user/info")
    @Override
    public void info(String id) {

    }

    @ResponseBody
    @RequestMapping("api/user/me")
    @Override
    public void me() {

    }
}