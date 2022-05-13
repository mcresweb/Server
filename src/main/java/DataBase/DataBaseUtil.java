package DataBase;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;


import java.sql.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.reflect.Array;


import Class.*;


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

    public static void initDataBase() throws ClassNotFoundException, SQLException, NoSuchFieldException, IllegalAccessException {
        generateTable("Class.MCResUser");
        generateTable("Class.Category");
        generateTable("Class.Keyword");
        generateTable("Class.Catalogue");
        //实验通用增删改查
//        add("Class.MCResUser", new MCResUser("1", "1", "1", 1, 1, false, 1));
//        add("Class.Category", new Category("1", "1", new byte[10]));
    }

    public static ResultSet add(String className, Object object) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        //获取类名
        String tableName = getClassName(className);
        //获取所有属性名
        HashMap<String, String> fileds = getFileds(className);

        String valueContent = "";
        String filedContent = "";
        //获取对象值
        int index = 0;
        for (String key : fileds.keySet()
        ) {
            index++;

            if (fileds.get(key).equals("String")) {
            } else if (fileds.get(key).equals("int")) {
                int value = object.getClass().getField(key).getInt(object);
            } else if (fileds.get(key).equals("long")) {
                long value = object.getClass().getField(key).getLong(object);
            } else if (fileds.get(key).equals("boolean")) {
                boolean value = object.getClass().getField(key).getBoolean(object);
            } else if (fileds.get(key).equals("byte[]")) {
                Array.newInstance(byte.class, Array.getLength(object.getClass().getField(key)));
                Class c1 = object.getClass().getField(key).getClass();
                c1.isArray();
                byte[] value = new byte[Array.getLength(object.getClass().getField(key))];
                System.arraycopy(object, 0, value, 0, Array.getLength(object.getClass().getField(key)));
                System.out.println(value.toString());

            } else {

                continue;
            }

            if (index != fileds.size()) {
                filedContent += ",";
                valueContent += ",";
            }
        }
        String sql = "insert into " + tableName + " (" + filedContent + ") value(" + valueContent + ");";

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
        String className = getClassName(name);
        if (checkTable(className)) {
            return;
        }
        //创建表
        Statement statement = connection.createStatement();
        String Sql = getGenerateSQLString(name);
        System.out.println(Sql);
        statement.executeUpdate(Sql, 2);

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

    public static String getClassName(String name) throws ClassNotFoundException {
        Class objectClass = Class.forName(name);
        String[] args = objectClass.getName().split("\\.");
        return args[args.length - 1];
    }

    public static HashMap<String, String> getFileds(String className) throws ClassNotFoundException {
        HashMap<String, String> filedNames = new HashMap<>();
        Class objectClass = Class.forName(className);
        for (Field field :
                objectClass.getFields()) {

            String[] filedContent = field.getGenericType().getTypeName().split("\\.");
            String filedName = filedContent[filedContent.length - 1];
            filedNames.put(field.getName(), filedName);
        }
        return filedNames;
    }

    public static String getGenerateSQLString(String name) throws SQLException, ClassNotFoundException {

        HashMap<String, String> filedNames = getFileds(name);
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

        return "CREATE TABLE `" + getClassName(name) + "` ("
                + otherFiledContet
                + ") ENGINE=InnoDB  DEFAULT CHARSET=utf8;";

    }

}
