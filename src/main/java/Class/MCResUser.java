package Class;

/**
 *  用户类
 */
public class MCResUser {
    /**
     *  唯一标识符 即ID
     */
    public String id;
    /**
     *  用户名
     */
    public String userName;
    /**
     *  密码
     */
    public String passWord;
    /**
     *  VIP等级 为0即不是VIP
     */
    public int vipLevel;
    /**
     *  VIP经验值
     */
    public int vipExpire;
    /**
     *  是否为管理员
     */
    public boolean isAdmin;
    /**
     *  这个用户注册的时间
     */
    public long createTime;

    /**
     * @param id 唯一标识符
     * @param userName  用户名
     * @param passWord  密码
     * @param vipLevel  VIP等级
     * @param vipExpire VIP经验值
     * @param isAdmin   是否为管理员
     * @param createTime    创建的时间
     */
    public MCResUser(String id, String userName, String passWord, int vipLevel, int vipExpire, boolean isAdmin, long createTime) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.vipLevel = vipLevel;
        this.vipExpire = vipExpire;
        this.isAdmin = isAdmin;
        this.createTime = createTime;
    }


    public MCResUser() {
    }
}
