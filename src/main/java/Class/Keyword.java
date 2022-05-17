package Class;

public class Keyword {
    /**
     *  唯一标识符
     */
    public String id;
    /**
     *  是否被使用
     */
    public boolean hasUsed;
    /**
     *  生成的时间
     */
    public long generateTime;
    /**
     *  到期时间
     */
    public long expirationTime;
    /**
     *  生成的用户ID
     */
    public String generateUserID;
    /**
     *  使用者的ID
     */
    public String UserId;

    public Keyword(String id, boolean hasUsed, long generateTime, long expirationTime, String generateUserID, String userId) {
        this.id = id;
        this.hasUsed = hasUsed;
        this.generateTime = generateTime;
        this.expirationTime = expirationTime;
        this.generateUserID = generateUserID;
        UserId = userId;
    }

    public Keyword() {
    }
}
