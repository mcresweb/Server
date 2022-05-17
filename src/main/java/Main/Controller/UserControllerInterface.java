package Main.Controller;

import Main.Class.*;

import java.sql.SQLException;

public interface UserControllerInterface {
    ReturnMSG login(String username, String password, long time) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException;

    ReturnMSG salt(String salt, String time);

    ReturnMSG logout();

    ReturnMSG register(String username, String password, String email, String code);

    ReturnMSG info(String id);

    ReturnMSG me();
}
