package com.strangengpuppies.strangengpuppies.dao;

import com.strangengpuppies.strangengpuppies.dao.base.UserDao;
import com.strangengpuppies.strangengpuppies.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public User findUserByUsername(String username) {
        List<User> users = new ArrayList<>();
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            users = session.createQuery("from User as U where U.username = :username", User.class)
                    .setParameter("username", username)
                    .list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }
}
