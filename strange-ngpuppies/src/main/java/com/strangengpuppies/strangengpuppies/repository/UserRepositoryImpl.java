package com.strangengpuppies.strangengpuppies.repository;

import com.strangengpuppies.strangengpuppies.model.User;
import com.strangengpuppies.strangengpuppies.repository.base.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
  
  private static SessionFactory factory;
  
  @Autowired
  public UserRepositoryImpl(SessionFactory factory) {
    this.factory = factory;
  }
  
  @Override
  public List<User> listAll() {
    List<User> users = new ArrayList<>();
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 users = session.createQuery("from User", User.class).list();
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
    return users;
  }
}
