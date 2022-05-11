package Dao;

import Class.User;

public interface UserDaoInterface {
    /**
     * @param account   用户名
     * @param password  密码
     * @return
     */
    User addUser(String account, String password);

    /**
     * @param account  用户名
     * @return
     */
    boolean deleteUser(String account);

    /**
     * @param user 用户
     * @return
     */
    boolean updateUser(User user);

    /**
     * @param account 账户名
     * @return
     */
    User getUser(String account);

}
