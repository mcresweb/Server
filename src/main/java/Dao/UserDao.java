package Dao;

import Class.User;

public class UserDao implements UserDaoInterface {
    @Override
    public User addUser(String account, String password) {
        return null;
    }

    @Override
    public boolean deleteUser(String account) {
        return false;
    }

    @Override
    public User getUser(String account) {
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
