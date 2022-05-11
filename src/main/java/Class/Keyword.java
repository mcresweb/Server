package Class;

public class Keyword {
    /**
     *  唯一标识符
     */
    private String id;
    /**
     *  是否被使用
     */
    private boolean hasUsed;
    /**
     *  生成的时间
     */
    private long generateTime;
    /**
     *  到期时间
     */
    private long expirationTime;
    /**
     *  生成的用户ID
     */
    private String generateUserID;
    /**
     *  使用者的ID
     */
    private String UserId;

    public Keyword(String id, boolean hasUsed, long generateTime, long expirationTime, String generateUserID, String userId) {
        this.id = id;
        this.hasUsed = hasUsed;
        this.generateTime = generateTime;
        this.expirationTime = expirationTime;
        this.generateUserID = generateUserID;
        UserId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isHasUsed() {
        return hasUsed;
    }

    public void setHasUsed(boolean hasUsed) {
        this.hasUsed = hasUsed;
    }

    public long getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(long generateTime) {
        this.generateTime = generateTime;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getGenerateUserID() {
        return generateUserID;
    }

    public void setGenerateUserID(String generateUserID) {
        this.generateUserID = generateUserID;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}
