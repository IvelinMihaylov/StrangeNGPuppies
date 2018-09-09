package com.strangengpuppies.strangengpuppies.web.RestControllers;

import com.strangengpuppies.strangengpuppies.model.Subscriber;
<<<<<<< HEAD:strange-ngpuppies/src/main/java/com/strangengpuppies/strangengpuppies/web/RestContrllers/SubscriberRestController.java
import com.strangengpuppies.strangengpuppies.model.User;
import com.strangengpuppies.strangengpuppies.model.formControl.FormCommand;
=======
import com.strangengpuppies.strangengpuppies.service.Exception.InvalidDateException;
>>>>>>> branch-ivelin:strange-ngpuppies/src/main/java/com/strangengpuppies/strangengpuppies/web/RestControllers/SubscriberRestController.java
import com.strangengpuppies.strangengpuppies.service.base.SubscriberService;
import com.strangengpuppies.strangengpuppies.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping (value = "api/subscriber", produces = MediaType.APPLICATION_JSON_VALUE)
public class SubscriberRestController {

  private final UserService userService;
  private final SubscriberService service;
  
  @Autowired
  public SubscriberRestController(UserService userService, SubscriberService service) {
    this.userService = userService;
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
  public List<Subscriber> getTopTenPayer() {
    return service.getTopTenPayer();
  }
  
  @GetMapping ("/getTopTenLastPayment")
  public List<Subscriber> getTopTenLastPayment() {
    return service.getTopTenLastPayment();
  }
  
  @PostMapping ("/create")
<<<<<<< HEAD:strange-ngpuppies/src/main/java/com/strangengpuppies/strangengpuppies/web/RestContrllers/SubscriberRestController.java
  public void createSubscriber(@ModelAttribute("command") FormCommand command, HttpServletResponse response) throws IOException {
    int id = Integer.parseInt(command.getDropdownSelectedValue());
    User bank = userService.listAllBanks().stream().filter(x -> x.getId() == id).findFirst().orElse(null);

    service.createSubscriber(command.getPhonenumber(),command.getFirstName(),command.getLastName(),command.getEgn(), bank);
    response.sendRedirect("/admin");
=======
  public void createSubscriber(Subscriber subscriber) throws InvalidDateException {
    service.createSubscriber(subscriber.getPhoneNumber(), subscriber.getFirstName(), subscriber.getLastName(), subscriber.getEgn());
>>>>>>> branch-ivelin:strange-ngpuppies/src/main/java/com/strangengpuppies/strangengpuppies/web/RestControllers/SubscriberRestController.java
  }
  
  @PostMapping ("/update")
  public void updateSubscriber(String currentlyPhonenumber, String newPhonenumber, String firstname, String lastname, String egn) {
    service.updateSubscriberByPhonenumber(currentlyPhonenumber, newPhonenumber, firstname, lastname, egn);
  }
  
  @PostMapping ("/delete/{phonenumber}")
  public void deleteSubscriber(@PathVariable ("phonenumber") String phonenumber) {
    service.deleteSubscriberByPhonenumber(phonenumber);
  }
  
}
