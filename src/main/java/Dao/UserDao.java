package Dao;

import Class.MCResUser;

public class UserDao implements UserDaoInterface {
    @Override
    public MCResUser addUser(String account, String password) {
        return null;
    }

    @Override
    public boolean deleteUser(String account) {
        return false;
    }

    @Override
    public MCResUser getUser(String account) {
        return null;
    }

    @Override
    public boolean updateUser(MCResUser user) {
        return false;
    }
}
