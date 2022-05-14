package Controller;

public interface TokenControllerInterface {
    void summon(String TimeStamp, int amount, int value);

    void list(String user, String summoner, int type, int page);

    void use(String token);

    void remove(String token);

}
