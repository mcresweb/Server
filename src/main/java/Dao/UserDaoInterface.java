package Dao;

import Class.MCResUser;

import java.sql.SQLException;

public interface UserDaoInterface {
    /**
     * @param username   用户名
     * @param password  密码
     * @return
     */
    MCResUser addUser(String username, String password) throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException;

    /**
     * @param id  唯一标识符
     * @return
     */
    boolean deleteUser(String id) throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException;

    /**
     * @param user 用户
     * @return
     */
    boolean updateUser(MCResUser user);

    /**
     * @param account 账户名
     * @return
     */
    MCResUser getUser(String account);

}
