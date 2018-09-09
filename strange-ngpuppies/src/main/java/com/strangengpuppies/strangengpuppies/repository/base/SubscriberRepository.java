package com.strangengpuppies.strangengpuppies.repository.base;

import com.strangengpuppies.strangengpuppies.model.Subscriber;
<<<<<<< HEAD
import com.strangengpuppies.strangengpuppies.model.User;
=======
>>>>>>> branch-ivelin

import java.util.List;

public interface SubscriberRepository {
  List<Subscriber> getAllSubscriber();
  
  Subscriber getById(String phonenumber);
<<<<<<< HEAD
  void createSubscriber(String phonenumber, String firstName, String lastName, String egn, User bank);
=======
  
  void createSubscriber(String phonenumber, String firstName, String lastName, String egn);
  
>>>>>>> branch-ivelin
  void updateSubscriber(Subscriber subscriber);
  
  void deleteSubscriber(Subscriber subscriber);
}
