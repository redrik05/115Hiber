package jm.task.core.jdbc;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    private  final static UserServiceImpl userService = new UserServiceImpl();
    public static void main(String[] args) {

//        userService.createUsersTable();
//        userService.saveUser("Igor", "Thudnovskyi", (byte) 34);
//        userService.saveUser("Elena", "Petrova", (byte) 24);
//        userService.saveUser("Oleg", "Zotkin", (byte) 26);
//        userService.saveUser("Viktoriya", "Basova", (byte) 28);
//        userService.getAllUsers();
//        userService.cleanUsersTable();
//        userService.dropUsersTable();
//
        // реализуйте алгоритм здесь
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Test1", "Test2", (byte) 35);
        userService.saveUser("Test2", "Test2", (byte) 30);
        userService.saveUser("Test3", "Test3", (byte) 25);
        userService.saveUser("Test4", "Test4", (byte) 15);
        List<User> userList = userService.getAllUsers();
        System.out.println(userList);
        userService.cleanUsersTable();
    }
}
