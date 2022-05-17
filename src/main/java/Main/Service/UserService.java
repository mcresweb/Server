package Main.Service;

import Main.Dao.UserDao;
import Main.Class.*;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService implements UserServiceInterface {
    private static UserDao userDao = new UserDao();

    public ReturnMSG login(String account, String password, long time) throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        MCResUser user = userDao.getUserFromAccount(account);
        if (user != null && user.passWord.equals(password)) {
            return new ReturnMSG() {{
                this.success = true;
                this.otherMSG.put("userid", user.id);

            }};
        } else {
            return new ReturnMSG() {{
                this.success = false;
                this.otherMSG.put("msg", "密码错误或这个用户不存在");
            }};
        }

    }

}
