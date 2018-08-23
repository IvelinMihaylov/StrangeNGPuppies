package com.strangengpuppies.strangengpuppies.service.base;

import com.strangengpuppies.strangengpuppies.model.Subscriber;
import com.strangengpuppies.strangengpuppies.model.User;

import java.util.List;

public interface SubscriberService {
  List<Subscriber> getAllSubscriber();
  Subscriber getByPhonenumber(String phonenumber);
  void createSubscriber(String phonenumber, String firstName, String lastName, String egn);
  void updateSubscriberByPhonenumber(String idPhonenumber, String phonenumber, String firstName, String lastName, String egn);
  void deleteSubscriberByPhonenumber(String phonenumber);
}
