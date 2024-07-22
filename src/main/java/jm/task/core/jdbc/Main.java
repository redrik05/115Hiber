package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService hiber = new UserServiceImpl();

        //hiber.dropUsersTable();
        hiber.createUsersTable();
        hiber.saveUser("Джон", "Дориан", (byte) 23);
        hiber.saveUser("Персиваль", "Кокс", (byte) 46);
        hiber.saveUser("Роберт", "Келсо", (byte) 65);
        hiber.saveUser("Убо", "Рщик", (byte) 45);
        hiber.removeUserById(1);

        // получение списка пользователей и вывод в консоль
        System.out.println(hiber.getAllUsers().get(0).getName());
        System.out.println(hiber.getAllUsers().get(1).getName());
        System.out.println(hiber.getAllUsers().get(2).getName());

        // очищение списка пользователей
        hiber.cleanUsersTable();
        System.out.println(hiber.getAllUsers().size());
        // удаление таблицы пользователей
        //hiber.dropUsersTable();
    }
}
