package com.strangengpuppies.strangengpuppies.repository;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.model.Subscriber;
import com.strangengpuppies.strangengpuppies.model.User;
import com.strangengpuppies.strangengpuppies.repository.base.SubscriberRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SubscriberRepositoryImpl implements SubscriberRepository {
  
  private final SessionFactory factory;
  
  @Autowired
  public SubscriberRepositoryImpl(SessionFactory factory) {
    this.factory = factory;
  }
  
  @Override
  public List<Subscriber> getAllSubscriber() {
    List<Subscriber> subscriber = new ArrayList<>();
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 subscriber = session.createQuery("from subscribers", Subscriber.class).list();
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
    return subscriber;
  }
  
  @Override
  public Subscriber getById(String phonenumber) {
    List<Subscriber> subscriber = new ArrayList<>();
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 subscriber = session.createQuery("from subscribers where phonenumber = " + phonenumber, Subscriber.class).list();
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
    if(subscriber.size() == 0) {
	 return null;
    }
    return subscriber.get(0);
  }
  
  @Override
  public void createSubscriber(String phonenumber, String firstName, String lastName, String egn) {
    User bank = new User();
    Subscriber subscriber = new Subscriber(phonenumber, firstName, lastName, egn, bank);
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 session.save(subscriber);
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
  }
  
  @Override
  public void updateSubscriber(Subscriber subscriber) {
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 session.update(subscriber);
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
  }
  
  @Override
  public void deleteSubscriber(Subscriber subscriber) {
    subscriber.setBank(null);
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 session.delete(subscriber);
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
  }
}
