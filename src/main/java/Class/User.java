package Class;

/**
 *  用户类
 */
public class User {
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
    public String password;
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

    public User(String id, String userName, String password, int vipLevel, int vipExpire, boolean isAdmin, long createTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.vipLevel = vipLevel;
        this.vipExpire = vipExpire;
        this.isAdmin = isAdmin;
        this.createTime = createTime;
    }

   
}
