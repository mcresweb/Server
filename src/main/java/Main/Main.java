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
    public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        SpringApplication.run(Main.class, args);
        DataBaseUtil.initDataBase();
        UserDao userDao = new UserDao();
        userDao.getUser("4117631eadb04de3b1e5a57933956fa3");
    }
}