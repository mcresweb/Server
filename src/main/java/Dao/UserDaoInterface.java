package Dao;

import Class.MCResUser;

public interface UserDaoInterface {
    /**
     * @param account   用户名
     * @param password  密码
     * @return
     */
    MCResUser addUser(String account, String password);

    /**
     * @param account  用户名
     * @return
     */
    boolean deleteUser(String account);

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
