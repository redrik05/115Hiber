package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
//        userService.createUsersTable();
//        userService.saveUser("Igor", "Thudnovskyi", (byte) 34);
//        userService.saveUser("Elena", "Petrova", (byte) 24);
//        userService.saveUser("Oleg", "Zotkin", (byte) 26);
//        userService.saveUser("Viktoriya", "Basova", (byte) 28);
//        userService.getAllUsers();
//        userService.cleanUsersTable();
//
        // реализуйте алгоритм здесь
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("igor","Thudo", (byte) 34);
        userService.saveUser("Test2","Test2", (byte) 30);
        userService.saveUser("Test3","Test3", (byte) 25);
        userService.removeUserById(1);
        List userList = userService.getAllUsers();
        System.out.println(userList);
        userService.cleanUsersTable();
    }
}
