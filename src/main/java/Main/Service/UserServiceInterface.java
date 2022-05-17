package Main.Service;

import Main.Class.*;

import java.sql.SQLException;

public interface UserServiceInterface {
     ReturnMSG login(String account,String password,long time) throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException;
}
