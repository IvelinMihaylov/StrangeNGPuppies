package com.strangengpuppies.strangengpuppies.repository;

import com.strangengpuppies.strangengpuppies.model.Role;
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
  
  @Override
  public void createClient(String username, String password, String eik) {
    Role role = new Role();
    role.setId(2);
    role.setName("ROLE_CLIENT");
    User client = new User(username, password, null, eik, role);
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 session.save(client);
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
  }
  
  @Override
  public void createAdministrator(String username, String password, String email) {
    Role role = new Role();
    role.setId(1);
    role.setName("ROLE_USER");
    User user = new User(username, password, email, null, role);
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 session.save(user);
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
  }
  
}
