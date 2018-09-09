package com.strangengpuppies.strangengpuppies.service.base;

import com.strangengpuppies.strangengpuppies.model.Subscriber;
<<<<<<< HEAD
import com.strangengpuppies.strangengpuppies.model.User;
=======
import com.strangengpuppies.strangengpuppies.service.Exception.InvalidDateException;
>>>>>>> branch-ivelin

import java.util.List;

public interface SubscriberService {
  List<Subscriber> getAllSubscriber();
  
  List<Subscriber> getTopTenPayer();
  
  List<Subscriber> getTopTenLastPayment();
  
  Subscriber getByPhonenumber(String phonenumber);
<<<<<<< HEAD
  void createSubscriber(String phonenumber, String firstName, String lastName, String egn, User bank);
=======
  
  void createSubscriber(String phonenumber, String firstName, String lastName, String egn) throws InvalidDateException;
  
>>>>>>> branch-ivelin
  void updateSubscriberByPhonenumber(String idPhonenumber, String phonenumber, String firstName, String lastName, String egn);
  
  void deleteSubscriberByPhonenumber(String phonenumber);
}
