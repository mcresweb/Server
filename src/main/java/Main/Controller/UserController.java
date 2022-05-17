package Main.Controller;

import Main.API.API;
import Main.Class.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
public class UserController implements UserControllerInterface {


    /**
     * @param username 用户名
     * @param password 密码
     * @param time     时间
     */
    @ResponseBody
    @RequestMapping("/api/user/login")
    @Override
    public ReturnMSG login(String username, String password, long time) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        return API.userService.login(username, password, time);
    }

    @ResponseBody
    @RequestMapping("/api/user/salt")
    @Override
    public ReturnMSG salt(String salt, String time) {
        return null;
    }

    @ResponseBody
    @RequestMapping("/api/user/")
    @Override
    public ReturnMSG logout() {
        return null;
    }

    @ResponseBody
    @RequestMapping("/api/user/register")
    @Override
    public ReturnMSG register(String username, String password, String email, String code) {
        return null;
    }

    @ResponseBody
    @RequestMapping("/api/user/info")
    @Override
    public ReturnMSG info(String id) {
        return null;
    }

    @ResponseBody
    @RequestMapping("/api/user/me")
    @Override
    public ReturnMSG me() {
        return null;
    }
}