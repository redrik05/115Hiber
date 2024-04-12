package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    public static String URL = "jdbc:mysql://localhost:3306/testKata?user=root&password=root&serverTimezone=UTC";
    public static String USERNAME ="root";
    public static String PASSWORD = "root";
    public static Connection getConnection() {
        Connection connection;
        try { connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {

                return connection;
            }
        } catch (SQLException e) {
            System.out.println("there is no connection... Exception!");
        }
        return null;
    }
}
