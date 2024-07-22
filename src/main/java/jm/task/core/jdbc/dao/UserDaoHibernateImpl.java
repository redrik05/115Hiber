package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private Util util = new Util();
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS User (id BIGINT AUTO_INCREMENT, name VARCHAR(255)" +
                ", last_name VARCHAR(255), age SMALLINT, PRIMARY KEY (id))";
        Session session = null;
        Transaction transaction = null;
        try {
            session = util.getSession();
            transaction = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        } catch (HibernateException h) {
            if (transaction!=null) {
                transaction.rollback();
                h.getStackTrace();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void dropUsersTable() {
        Session session = null;
        Transaction transaction = null;
        try {
            session = util.getSession();
            transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS user").executeUpdate();
            transaction.commit();
        } catch (HibernateException h) {
            if (transaction!=null) {
                transaction.rollback();
                h.getStackTrace();
            }
        } finally {
            session.close();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = util.getSession();
            transaction = session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            transaction.commit();
        } catch (HibernateException h) {
            if (transaction!=null) {
                transaction.rollback();
                h.getStackTrace();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void removeUserById(long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = util.getSession();
            transaction = session.beginTransaction();
            session.createSQLQuery("DELETE FROM user WHERE id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            transaction.commit();
        } catch (HibernateException h) {
            if (transaction!=null) {
                transaction.rollback();
                h.getStackTrace();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        Session session = null;
        Transaction transaction = null;
        List<User> list = new ArrayList<>();
        try {
            session = util.getSession();
            transaction = session.beginTransaction();
            list = session.createQuery("from User", User.class).list();
            transaction.commit();
        } catch (HibernateException h) {
            if (transaction!=null) {
                transaction.rollback();
                h.getStackTrace();
            }
        } finally {
            session.close();
        }
       return list;
    }

    @Override
    public void cleanUsersTable() {
        Session session = null;
        Transaction transaction = null;
        try {
            session = util.getSession();
            transaction = session.beginTransaction();
            session.createSQLQuery("DELETE FROM user")
                    .executeUpdate();
            transaction.commit();
        } catch (HibernateException h) {
            if (transaction!=null) {
                transaction.rollback();
                h.getStackTrace();
            }
        } finally {
            session.close();
        }
    }

}
