package com.strangengpuppies.strangengpuppies.service;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.model.Subscriber;
import com.strangengpuppies.strangengpuppies.model.User;
import com.strangengpuppies.strangengpuppies.repository.base.SubscriberRepository;
import com.strangengpuppies.strangengpuppies.service.base.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class SubscriberServiceImpl implements SubscriberService {
  private final SubscriberRepository subscriberRepository;
  
  @Autowired
  public SubscriberServiceImpl(SubscriberRepository subscriberRepository) {
    this.subscriberRepository = subscriberRepository;
  }
  
  public Double changerCurrency(String currency) {
    if(currency.equals("USD")) {
	 return 1.6829;
    }
    if(currency.equals("EUR")) {
	 return 1.9559;
    }
    if(currency.equals("GBP")) {
	 return 2.1619;
    }
    if(currency.equals("RUB")) {
	 return 0.0251;
    }
    return 1.0;
  }
  
  @Override
  public List<Subscriber> getAllSubscriber() {
    return subscriberRepository.getAllSubscriber();
  }
  
  @Override
  public List<Subscriber> getTopTenPayer() {
    List<Subscriber> subscribers = subscriberRepository.getAllSubscriber();
    Map<Double, List<Subscriber>> result = new TreeMap<>();
    for(Subscriber subscriber : subscribers) {
	 double amount = 0;
	 for(Bill bill : subscriber.getBills()) {
	   amount += bill.getAmount() * changerCurrency(bill.getCurrency());
	 }
	 if(!result.containsKey(amount)) {
	   result.put(amount, new ArrayList<>());
	 }
	 result.get(amount).add(subscriber);
    }
    subscribers.clear();
    while(subscribers.size() <= 10) {
	 if(result.size() != 0) {
	   for(Subscriber sub : ((TreeMap<Double, List<Subscriber>>) result).lastEntry().getValue()) {
		subscribers.add(sub);
	   }
	   result.remove(((TreeMap<Double, List<Subscriber>>) result).lastKey());
	 }else {
	   return subscribers;
	 }
    }
    return subscribers;
  }
  
  @Override
  public List<Subscriber> getTopTenLastPayment() {
    return null;
  }
  
  @Override
  public Subscriber getByPhonenumber(String phonenumber) {
    return subscriberRepository.getById(phonenumber);
  }
  
  @Override
  public void createSubscriber(String phonenumber, String firstName, String lastName, String egn) {
    subscriberRepository.createSubscriber(phonenumber, firstName, lastName, egn);
  }
  
  @Override
  public void updateSubscriberByPhonenumber(String idPhonenumber, String phonenumber, String firstName, String lastName, String egn) {
    Subscriber subscriber = subscriberRepository.getById(idPhonenumber);
    if(phonenumber != null) {
	 if(phonenumber.length() > 0) {
	   subscriber.setPhoneNumber(phonenumber);
	 }
    }
    if(firstName != null) {
	 if(firstName.length() > 0) {
	   subscriber.setFirstName(firstName);
	 }
    }
    if(lastName != null) {
	 if(lastName.length() > 0) {
	   subscriber.setLastName(lastName);
	 }
	 
    }
    if(egn != null) {
	 if(egn.length() > 0) {
	   subscriber.setEgn(egn);
	 }
	 
    }
    subscriberRepository.updateSubscriber(subscriber);
  }
  
  @Override
  public void deleteSubscriberByPhonenumber(String phonenumber) {
    Subscriber subscriber = subscriberRepository.getById(phonenumber);
    subscriberRepository.deleteSubscriber(subscriber);
  }
}
