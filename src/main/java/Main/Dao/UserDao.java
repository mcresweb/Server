package Main.Dao;

import Main.Class.MCResUser;
import Main.DataBase.DataBaseUtil;

import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

public class UserDao implements UserDaoInterface {
    @Override
    public MCResUser addUser(String username, String password) throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException {
        MCResUser mcResUser = new MCResUser(UUID.randomUUID().toString().replace("-", "").toLowerCase(), username, password, 0, 0, false, new Date().getTime());
        DataBaseUtil.add("Main.Class.MCResUser", mcResUser);
        return mcResUser;
    }

    @Override
    public boolean deleteUser(String id) throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException {
        return DataBaseUtil.delete("Main.Class.MCResUser", id);
    }

    @Override
    public boolean updateUser(MCResUser user) throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException {
        return DataBaseUtil.update("Main.Class.MCResUser", user);
    }

    @Override
    public MCResUser getUserFromId(String id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        return (MCResUser) DataBaseUtil.selectFromAttribute("Main.Class.MCResUser", "id", id);
    }

    @Override
    public MCResUser getUserFromAccount(String userName) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        return (MCResUser) DataBaseUtil.selectFromAttribute("Main.Class.MCResUser", "userName", userName);
    }
}
