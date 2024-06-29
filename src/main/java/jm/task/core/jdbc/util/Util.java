package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/mydbtest";
    private static final String DB_NAME ="roottyt";
    private static final String DB_PASSWORD = "roottyt";

    public static Connection getConnect(){
        Connection connection = null;
        try{
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_NAME,DB_PASSWORD);
        } catch (ClassNotFoundException|SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
