package com.strangengpuppies.strangengpuppies.web.RestContrllers;

import com.strangengpuppies.strangengpuppies.model.Subscriber;
import com.strangengpuppies.strangengpuppies.service.base.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
  
  @GetMapping ("/getTopTenPayer")
  public List<Subscriber> getTopTenPayer(){
    return service.getTopTenPayer();
  }
  
  @PostMapping ("/create")
  public void createSubscriber(Subscriber subscriber) {
  service.createSubscriber(subscriber.getPhoneNumber(),subscriber.getFirstName(),subscriber.getLastName(),subscriber.getEgn());
  }
  
  @PostMapping ("/update")
  public void updateSubscriber(String currentlyPhonenumber, String newPhonenumber, String firstname, String lastname, String egn ) {
  service.updateSubscriberByPhonenumber(currentlyPhonenumber, newPhonenumber, firstname, lastname, egn);
  }
  
  @PostMapping ("/delete/{phonenumber}")
  public void deleteSubscriber(@PathVariable ("phonenumber") String phonenumber) {
  service.deleteSubscriberByPhonenumber(phonenumber);
  }
  
}
