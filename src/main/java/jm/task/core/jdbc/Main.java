package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Util util = new Util();
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        List<User> arr = new ArrayList<>();
        arr.add(new User("Name1", "LastName1", (byte) 20));
        arr.add(new User("Name2", "LastName2", (byte) 25));
        arr.add(new User("Name3", "LastName3", (byte) 31));
        arr.add(new User("Name4", "LastName4", (byte) 38));
        for (User user: arr) {
            userService.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.println("User с именем – " + user.getName() + " добавлен в базу данных");
        }

        userService.removeUserById(1);

        List<User> usersTable = userService.getAllUsers();
        for (User user : usersTable) {
            System.out.println(user);
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
