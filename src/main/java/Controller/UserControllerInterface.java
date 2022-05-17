package Controller;

public interface UserControllerInterface {
    void login(String username, String password, long time);

    void salt(String salt, String time);

    void logout();

    void register(String username,String password,String email,String code);

    void info(String id);

    void me();
}
