package com.strangengpuppies.strangengpuppies.repository.base;

import com.strangengpuppies.strangengpuppies.model.Subscriber;
import com.strangengpuppies.strangengpuppies.model.User;
import java.util.List;

public interface SubscriberRepository {
  List<Subscriber> getAllSubscriber();
  
  Subscriber getById(String phonenumber);

  void createSubscriber(String phonenumber, String firstName, String lastName, String egn, User bank);

  void updateSubscriber(Subscriber subscriber);
  
  void deleteSubscriber(Subscriber subscriber);
}
