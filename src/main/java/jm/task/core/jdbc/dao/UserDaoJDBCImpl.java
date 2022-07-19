package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String SQL = "CREATE TABLE User \n" +
                "(\n" +
                "\tId BIGINT auto_increment primary key, \n" +
                "\tFirstName VARCHAR(20), \n" +
                "    LastName VARCHAR(20),\n" +
                "\tAge TINYINT\n" +
                ");";
        Util.getConnection(SQL);
    }

    public void dropUsersTable() {
        String SQL = "drop table User;";
        Util.getConnection(SQL);
    }

    public void saveUser(String name, String lastName, byte age) {
        String SQL = "INSERT INTO user (FirstName, LastName, age) VALUES ('" + name + "', '" + lastName + "', "+ age + ");" ;
        Util.getConnection(SQL);
    }

    public void removeUserById(long id) {
        String SQL = "DELETE FROM Products WHERE Id = 3";
        Util.getConnection(SQL);

    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
       String SQL = "SELECT * FROM User";
       ResultSet resultSet = Util.getConnection(SQL);
//        try {
//            ResultSet resultSet = statement.executeQuery(SQL);
//            while (resultSet.next()){
//                User user = new User();
//                user.setId((long) resultSet.getInt("id"));
//                user.setName(resultSet.getString("name"));
//                user.setName(resultSet.getString("lastName"));
//                user.setAge((byte) resultSet.getInt("age"));
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        return null;
    }

    public void cleanUsersTable() {

    }
}
