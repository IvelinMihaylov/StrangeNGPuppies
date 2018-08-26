package com.strangengpuppies.strangengpuppies.service.base;

import com.strangengpuppies.strangengpuppies.model.Subscriber;

import java.util.List;

public interface SubscriberService {
  List<Subscriber> getAllSubscriber();
  List<Subscriber> getTopTenPayer();
  List<Subscriber> getTopTenLastPayment();
  Subscriber getByPhonenumber(String phonenumber);
  void createSubscriber(String phonenumber, String firstName, String lastName, String egn);
  void updateSubscriberByPhonenumber(String idPhonenumber, String phonenumber, String firstName, String lastName, String egn);
  void deleteSubscriberByPhonenumber(String phonenumber);
}
