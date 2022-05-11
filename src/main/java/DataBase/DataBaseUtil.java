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


        //5、执行sql的对象 去执行sql，可能存在结果，查看返回结果
//        String sql = "SELECT* FROM `users`";
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);//返回的结果集，结果集中封装了我们全部的查询出来的结果
//        while (resultSet.next()) {
//            System.out.println("id=" + resultSet.getObject("id"));
//            System.out.println("name=" + resultSet.getObject("name"));
//            System.out.println("pwd=" + resultSet.getObject("password"));
//            System.out.println("email=" + resultSet.getObject("email"));
//            System.out.println("birthday=" + resultSet.getObject("birthday"));
//            System.out.println("--------------------------");
//        }

        //6、释放连接
//        resultSet.close();
//        statement.close();
//        connection.close();
        generateTable("Class.User");
    }

    public static void generateTable(String name) throws ClassNotFoundException, SQLException {
        HashMap<String, String> filedNames = new HashMap<>();
        Class objectClass = Class.forName(name);
        String[] args = objectClass.getName().split("\\.");

        String className = args[args.length - 1];
        for (Field field :
                objectClass.getFields()) {

            String[] filedContent = field.getGenericType().getTypeName().split("\\.");
            String filedName = filedContent[filedContent.length - 1];
            filedNames.put(field.getName(),filedName);
            System.out.println(field.getName() + " : " + filedName);
        }
        Statement statement = connection.createStatement();

    //创建表
        String otherFiledContet="";

        for (String key:filedNames.keySet()
             ) {

        }
        String createTableSql = "CREATE TABLE `" + className + "` ("

                + "`id` int(11) NOT NULL AUTO_INCREMENT,"

                + "`name` varchar(20) DEFAULT NULL,"

                + "PRIMARY KEY (`id`)"

                + ") ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;";

        statement.executeUpdate(createTableSql, 2);


    }

    public boolean checkTable(String tableName) {
        try {
            String sql = "SELECT 1 FROM ALL_ALL_TABLES WHERER TABLE_NAME =" + tableName;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.first())
                return true;
            else return false;
        } catch (Exception e) {
            System.out.println("表不存在");
            return false;
        }
    }


}
