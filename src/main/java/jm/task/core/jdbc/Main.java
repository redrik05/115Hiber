package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Igor", "Thudnovskyi", (byte) 34);
        userDaoJDBC.saveUser("Elena", "Petrova", (byte) 24);
        userDaoJDBC.saveUser("Oleg", "Zotkin", (byte) 26);
        userDaoJDBC.saveUser("Viktoriya", "Basova", (byte) 28);
        userDaoJDBC.getAllUsers();
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();
        // реализуйте алгоритм здесь
    }
}
