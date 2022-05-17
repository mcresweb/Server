package Main.Dao;

import java.util.concurrent.ConcurrentHashMap;

public class PersistentData {
    public String publicSalt = "testPublicSalt";
    public static ConcurrentHashMap<String, String> category;
    public static ConcurrentHashMap<String, String> catalogue;
}
