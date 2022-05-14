package DataBase;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;


import java.io.File;
import java.sql.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
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

    /**
     * 初始化， 建表
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static void initDataBase() throws ClassNotFoundException, SQLException, NoSuchFieldException, IllegalAccessException {
        generateTable("Class.MCResUser");
        generateTable("Class.Category");
        generateTable("Class.Keyword");
        generateTable("Class.Catalogue");

    }

    /**
     * @param className 类名（包括报名 例 Class.User）
     * @param object 对象（随便一个实例）
     * @return 是否成功增添一个数据对象到数据库
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws SQLException
     */
    public static boolean add(String className, Object object) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, SQLException {
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
                String value = object.getClass().getField(key).get(object).toString();
                filedContent += key;
                valueContent += "'" + value + "'";
            } else if (fileds.get(key).equals("int")) {
                int value = object.getClass().getField(key).getInt(object);
                filedContent += key;
                valueContent += value;
            } else if (fileds.get(key).equals("long")) {
                long value = object.getClass().getField(key).getLong(object);
                filedContent += key;
                valueContent += value;
            } else if (fileds.get(key).equals("boolean")) {
                boolean value = object.getClass().getField(key).getBoolean(object);
                filedContent += key;
                valueContent += value;
            } else if (fileds.get(key).equals("byte[]")) {
                Object obj = object.getClass().getField(key).get(object);
                Array.newInstance(byte.class, Array.getLength(obj));
                byte[] value = new byte[Array.getLength(obj)];
                System.arraycopy(obj, 0, value, 0, Array.getLength(obj));
                String valueString = new String(value);
                filedContent += key;
                valueContent = "'" + valueString + "'";
            } else {
                continue;
            }
            if (index != fileds.size()) {
                filedContent += ",";
                valueContent += ",";
            }
        }
        String sql = "insert into " + tableName + " (" + filedContent + ") value (" + valueContent + ");";
        Statement statement = connection.createStatement();
        System.out.println(sql);
        return statement.execute(sql);
    }

    public static boolean delete(String className, String id) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, SQLException {
        //获取类名
        String tableName = getClassName(className);
        //获取所有属性名
        String sql = "DELETE FROM " + tableName + " WHERE id='" + id + "' ;";
        Statement statement = connection.createStatement();
        System.out.println(sql);
        return statement.execute(sql);
    }

    public static boolean update(String className, Object object) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, SQLException {
        //获取类名
        String tableName = getClassName(className);
        //获取所有属性名
        HashMap<String, String> fileds = getFileds(className);

        String id = "";
        String content = "";
        //获取对象值
        int index = 0;
        for (String key : fileds.keySet()
        ) {
            index++;
            if (key.equals("id")) {
                id = object.getClass().getField(key).get(object).toString();
                continue;
            }
            if (fileds.get(key).equals("String")) {
                String value = object.getClass().getField(key).get(object).toString();
                content += key + "= '" + value + "'";
            } else if (fileds.get(key).equals("int")) {
                int value = object.getClass().getField(key).getInt(object);
                content += key + "= " + value;
            } else if (fileds.get(key).equals("long")) {
                long value = object.getClass().getField(key).getLong(object);
                content += key + "= " + value;
            } else if (fileds.get(key).equals("boolean")) {
                boolean value = object.getClass().getField(key).getBoolean(object);
                content += key + "= " + value;
            } else if (fileds.get(key).equals("byte[]")) {
                Object obj = object.getClass().getField(key).get(object);
                Array.newInstance(byte.class, Array.getLength(obj));
                byte[] value = new byte[Array.getLength(obj)];
                System.arraycopy(obj, 0, value, 0, Array.getLength(obj));
                String valueString = new String(value);
                content += key + "= '" + valueString + "'";
            } else {
                continue;
            }
            if (index != fileds.size()) {
                content += ",";
            }
        }

        String sql = "update " + tableName + " set " + content + "where id = '" + id + "';";
        System.out.println(sql);

        Statement statement = connection.createStatement();
        return statement.execute(sql);
    }

    public static ResultSet select(String className, String id) throws ClassNotFoundException, SQLException {
        String tableName = getClassName(className);
        String sql = "SELECT * FROM " + tableName + " WHERE id= '" + id + "'";
        Statement statement = connection.createStatement();
        System.out.println(sql);
        return statement.executeQuery(sql);
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
