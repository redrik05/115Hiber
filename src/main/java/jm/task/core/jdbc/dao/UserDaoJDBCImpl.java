package jm.task.core.jdbc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;


public class UserDaoJDBCImpl implements UserDao {
    Connection connection = Util.getConnect();
    public UserDaoJDBCImpl() {};
        public void createUsersTable() {
            String sql = "CREATE TABLE IF NOT EXISTS User (id SERIAL PRIMARY KEY, name VARCHAR(50), lastName VARCHAR(50), age TINYINT)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
               e.printStackTrace();
            }

        }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS User";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
            String sql ="INSERT INTO User (name, lastName, age) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        if (id <= 0) {
            System.out.println("Некорректный идентификатор пользователя");
            return;
        }

        String sql = "DELETE FROM User WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Пользователь с id " + id + " удален");
            } else {
                System.out.println("Пользователь с id " + id + " не найден");
            }

            System.out.println("Пользователь удален");

        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при удалении пользователя", e);
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM User";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM User")) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {
        String sql = "DELETE FROM User";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
