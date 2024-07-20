package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private Util util = new Util();
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try (SessionFactory sessionFactory = util.getSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

        } catch (HibernateException he) {
            System.out.println("hiber подвел " + he);
        }
    }

    @Override
    public void dropUsersTable() {
        try (SessionFactory sessionFactory = util.getSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

        } catch (HibernateException he) {
            System.out.println("hiber подвел " + he);
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (SessionFactory sessionFactory = util.getSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

        } catch (HibernateException he) {
            System.out.println("hiber подвел " + he);
        }
    }

    @Override
    public void removeUserById(long id) {
        try (SessionFactory sessionFactory = util.getSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            User user = session.get(User.class, (int) id);
            session.delete(user);
            session.getTransaction().commit();

        } catch (HibernateException he) {
            System.out.println("hiber подвел " + he);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (SessionFactory sessionFactory = util.getSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

        } catch (HibernateException he) {
            System.out.println("hiber подвел " + he);
        }
        return null;
    }

    @Override
    public void cleanUsersTable() {
        try (SessionFactory sessionFactory = util.getSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

        } catch (HibernateException he) {
            System.out.println("hiber подвел " + he);
        }
    }

    //Получение персоны
    public void getUser() {
        try (SessionFactory sessionFactory = util.getSessionFactory();
        Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            User user = session.get(User.class, 1);
            System.out.println(user.getName());
            System.out.println(user.getAge());

            session.getTransaction().commit();
        } catch (HibernateException he) {
            System.out.println("hiber подвел " + he);
        }
    }
}
