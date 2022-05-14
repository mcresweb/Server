package Main;


import Dao.UserDao;
import DataBase.DataBaseUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Class.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        SpringApplication.run(Main.class, args);
        DataBaseUtil.initDataBase();
        UserDao userDao = new UserDao();
        userDao.addUser("wula", "ceshimima");
    }
}