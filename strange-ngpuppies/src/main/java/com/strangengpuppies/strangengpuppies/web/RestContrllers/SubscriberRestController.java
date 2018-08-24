package com.strangengpuppies.strangengpuppies.web.RestContrllers;

import com.strangengpuppies.strangengpuppies.model.Subscriber;
import com.strangengpuppies.strangengpuppies.service.base.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("api/subscriber")
public class SubscriberRestController {
  
  private final SubscriberService service;
  
  @Autowired
  public SubscriberRestController(SubscriberService service) {
    this.service = service;
  }
  
  @GetMapping ("/getAll")
  public List<Subscriber> getAll() {
    return service.getAllSubscriber();
  }
  
  @GetMapping ("/byID/{phonenumber}")
  public Subscriber getByID(@PathVariable ("phonenumber") String phonenumber) {
    return service.getByPhonenumber(phonenumber);
  }
  
  @GetMapping ("/create")
  public void createSubscriber(Subscriber subscriber) {
  service.createSubscriber(subscriber.getPhoneNumber(),subscriber.getFirstName(),subscriber.getLastName(),subscriber.getEgn());
  }
  
  @GetMapping ("/update")
  public void updateSubscriber(String idPhonenumber, Subscriber subscriber) {
  service.updateSubscriberByPhonenumber(idPhonenumber,subscriber.getPhoneNumber(),subscriber.getFirstName(),subscriber.getLastName(),subscriber.getEgn());
  }
  
  @GetMapping ("/delete/{phonenumber}")
  public void deleteSubscriber(@PathVariable ("phonenumber") String phonenumber) {
  service.deleteSubscriberByPhonenumber(phonenumber);
  }
  
}
