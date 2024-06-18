package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE USER (Id INT PRIMARY KEY AUTO_INCREMENT" +
                     ", Name VARCHAR(45), LastName VARCHAR(45), Age INT)";
        try (PreparedStatement preparedStatement = Util.connect.prepareStatement(sql)) {
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println();
        }
    }


    public void dropUsersTable() {
        String sql = "DROP TABLE USER ";
        try (PreparedStatement preparedStatement = Util.connect.prepareStatement(sql)) {
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO USER (`Name`, `LastName`, `Age`) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = Util.connect.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем — " + name + " добавлен в базу данных");

        } catch (SQLException ex) {
            System.out.println();
        }
    }

    public void removeUserById(long id) {

        String sql = "DELETE FROM USER WHERE `Id` = " + id;
        try (PreparedStatement preparedStatement = Util.connect.prepareStatement(sql)) {
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println();
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT `Id`, `Name`, `LastName`, `Age` FROM USER";
        try (Statement statement = Util.connect.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("Id"));
                user.setName(resultSet.getString("Name"));
                user.setLastName(resultSet.getString("LastName"));
                user.setAge(resultSet.getByte("Age"));
                userList.add(user);
                System.out.println(user);
            }

        } catch (SQLException e) {
            System.out.println();
        }
        return userList;
    }

    public void cleanUsersTable() {
        String sql = "DELETE FROM USER";
        try (PreparedStatement preparedStatement = Util.connect.prepareStatement(sql)) {
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println();
        }
    }
}//торбен янсон
