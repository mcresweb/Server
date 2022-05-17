package Dao;

import Class.MCResUser;
import DataBase.DataBaseUtil;

import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

public class UserDao implements UserDaoInterface {
    @Override
    public MCResUser addUser(String username, String password) throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException {
        MCResUser mcResUser = new MCResUser(UUID.randomUUID().toString().replace("-", "").toLowerCase(), username, password, 0, 0, false, new Date().getTime());
        DataBaseUtil.add("Class.MCResUser", mcResUser);
        return mcResUser;
    }

    @Override
    public boolean deleteUser(String id) throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException {
        return DataBaseUtil.delete("Class.MCResUser", id);
    }

    @Override
    public MCResUser getUser(String id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        return (MCResUser) DataBaseUtil.select("Class.MCResUser", id);

    }

    @Override
    public boolean updateUser(MCResUser user) {

        return false;
    }
}
