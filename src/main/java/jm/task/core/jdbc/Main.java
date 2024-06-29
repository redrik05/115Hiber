package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Dmitry","tashkinov",(byte) 26);
        userService.saveUser("Dmitry","tashkinov",(byte) 26);
        userService.saveUser("Dmitry","tashkinov",(byte) 26);
        userService.saveUser("Dmitry","tashkinov",(byte) 26);
        userService.getAllUsers();
    }
}
