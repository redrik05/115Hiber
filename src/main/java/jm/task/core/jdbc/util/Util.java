package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    @PersistenceContext
    EntityManager entityManager;
    private Connection connection = null;
    private SessionFactory sessionFactory = null;
    private Session session = null;
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "My24SQL";

    public void createConnection() throws SQLException {
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public Connection getConnection() throws SQLException {
        createConnection();
        return connection;
    }

    public Session getSession() {
        return new Configuration()
                .addAnnotatedClass(User.class).buildSessionFactory().getCurrentSession();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
