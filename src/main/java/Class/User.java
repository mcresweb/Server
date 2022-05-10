package Class;

/**
 *  用户类
 */
public class User {
    /**
     *  唯一标识符 即ID
     */
    private String id;
    /**
     *  用户名
     */
    private String userName;
    /**
     *  密码
     */
    private String password;
    /**
     *  VIP等级 为0即不是VIP
     */
    private int vipLevel;
    /**
     *  VIP经验值
     */
    private int vipExpire;
    /**
     *  是否为管理员
     */
    private boolean isAdmin;
    /**
     *  这个用户注册的时间
     */
    private long createTime;

    public User(String id, String userName, String password, int vipLevel, int vipExpire, boolean isAdmin, long createTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.vipLevel = vipLevel;
        this.vipExpire = vipExpire;
        this.isAdmin = isAdmin;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(int vipLevel) {
        this.vipLevel = vipLevel;
    }

    public int getVipExpire() {
        return vipExpire;
    }

    public void setVipExpire(int vipExpire) {
        this.vipExpire = vipExpire;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
