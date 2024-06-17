package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Igor", "Thudnovskyi", (byte) 34);
        userService.saveUser("Elena", "Petrova", (byte) 24);
        userService.saveUser("Oleg", "Zotkin", (byte) 26);
        userService.saveUser("Viktoriya", "Basova", (byte) 28);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
        // реализуйте алгоритм здесь
    }
}
