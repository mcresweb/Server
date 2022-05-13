package DataBase;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;


import java.sql.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;


public class DataBaseUtil {
    @Autowired
    public static Environment environment;

    public static String username;
    public static String password;
    public static String url;
    public static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //3、连接成功，数据库对象 Connection 代表数据库
            url = "jdbc:mysql://localhost:3306/mcresweb?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&currentSchema=owas";
            username = "root";
            password = "";
            connection = DriverManager.getConnection(url, username, password);
            //4、执行sql对象 statement 执行sql的对象

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void initDataBase() throws ClassNotFoundException, SQLException {
        generateTable("Class.MCResUser");
        generateTable("Class.Category");
        generateTable("Class.Keyword");
        generateTable("Class.Catalogue");
    }

    public ResultSet add() {
        return null;
    }

    public ResultSet delete() {
        return null;
    }

    public ResultSet update() {
        return null;
    }

    public ResultSet select() {
        return null;
    }


    /**
     * 把一个类创建一张表存储在数据库中
     *
     * @param name 类的名称(包括包名)
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void generateTable(String name) throws ClassNotFoundException, SQLException {

        HashMap<String, String> filedNames = new HashMap<>();
        Class objectClass = Class.forName(name);
        String[] args = objectClass.getName().split("\\.");

        String className = args[args.length - 1];
        if (checkTable(className)) {
            return;
        }


        for (Field field :
                objectClass.getFields()) {
            String[] filedContent = field.getGenericType().getTypeName().split("\\.");
            String filedName = filedContent[filedContent.length - 1];
            filedNames.put(field.getName(), filedName);
        }
        Statement statement = connection.createStatement();
        //创建表
        String otherFiledContet = "";
        int index = 0;
        for (String key : filedNames.keySet()
        ) {
            index++;
            String filedType = "";
            if (filedNames.get(key).equals("String")) {
                filedType = " varchar";
            } else if (filedNames.get(key).equals("int") || filedNames.get(key).equals("long")) {
                filedType = " bigint";
            } else if (filedNames.get(key).equals("boolean")) {
                filedType = " boolean";
            } else if (filedNames.get(key).equals("byte[]")) {
                filedType = " binary";
            } else {
                System.out.println(key + " : " + filedNames.get(key));
                continue;
            }
            otherFiledContet += key;


            if (!filedNames.get(key).equals("boolean")) {
                otherFiledContet = otherFiledContet + filedType + "(255)";

            } else {
                otherFiledContet = otherFiledContet + filedType;
            }


            if (key.equals("id")) {
                otherFiledContet = otherFiledContet + " PRIMARY KEY";
            }
            if (index != filedNames.size()) {
                otherFiledContet += ",";
            }
        }

        String createTableSql = "CREATE TABLE `" + className + "` ("
                + otherFiledContet
                + ") ENGINE=InnoDB  DEFAULT CHARSET=utf8;";

        System.out.println(createTableSql);
        statement.executeUpdate(createTableSql, 2);

    }

    public static boolean checkTable(String tableName) {
        try {

            String sql = "select * from information_schema.TABLES where TABLE_NAME = '" + tableName + "'";
            Statement statement = connection.createStatement();
            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.first())
                return true;
            else return false;
        } catch (Exception e) {
            return false;
        }
    }


}
