package Dao;

import Class.User;

public interface UserDaoInterface {
    /**
     * @param account
     * @param password
     * @return
     */
    User addUser(String account, String password);


}
