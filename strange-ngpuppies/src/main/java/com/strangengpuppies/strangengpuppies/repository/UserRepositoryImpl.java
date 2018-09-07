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
    private SessionFactory factory;

    @Autowired
    public UserRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        try(Session session = factory.openSession()){
            session.beginTransaction();
            users = session.createQuery("from User", User.class).list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return users;
    }
  
  @Override
  public User getUserById(int id) {
    User user = new User();
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 user = session.get(User.class, id);
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
    return user;
  }
  
  @Override
  public void updateUser(User user) {
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 session.update(user);
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
    
  }
  
  @Override
  public void deleteUser(User user) {
    user.setEik(null);
    user.setRole(null);
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 session.delete(user);
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
  }
  
  @Override
  public void createClient(String username, String password, String eik) {
        List<User> users = new ArrayList<>(listAll());
        Role role = new Role();
    role.setId(2);
    role.setName("USER");
    User client = new User(username, password, ""+(users.get(users.size() - 1).getId()), eik, role);
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
    role.setName("ADMIN");
    User user = new User(username, password, email, "",role);
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 session.save(user);
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
  }
}
