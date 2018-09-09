package com.strangengpuppies.strangengpuppies.web.RestControllers;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.model.Service;
import com.strangengpuppies.strangengpuppies.model.Subscriber;
<<<<<<< HEAD:strange-ngpuppies/src/main/java/com/strangengpuppies/strangengpuppies/web/RestContrllers/BillRestController.java
import com.strangengpuppies.strangengpuppies.model.formControl.FormCommand;
=======
import com.strangengpuppies.strangengpuppies.service.Exception.CurrencyException;
>>>>>>> branch-ivelin:strange-ngpuppies/src/main/java/com/strangengpuppies/strangengpuppies/web/RestControllers/BillRestController.java
import com.strangengpuppies.strangengpuppies.service.base.BillService;
import com.strangengpuppies.strangengpuppies.service.base.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

<<<<<<< HEAD:strange-ngpuppies/src/main/java/com/strangengpuppies/strangengpuppies/web/RestContrllers/BillRestController.java
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
=======
>>>>>>> branch-ivelin:strange-ngpuppies/src/main/java/com/strangengpuppies/strangengpuppies/web/RestControllers/BillRestController.java
import java.util.List;

@RestController
@RequestMapping ("api/bill")
public class BillRestController {
  
  private final BillService service;
  private final SubscriberService subscriberService;
  
  @Autowired
  public BillRestController(BillService service, SubscriberService subscriberService) {
    this.service = service;
    this.subscriberService = subscriberService;
  }
  
  @GetMapping ("/listAll")
  public List<Bill> getAll() {
    return service.getAllBills();
  }
  
  @GetMapping ("/history")
  List<Bill> getReadyBills() {
    return service.getReadyBills();
  }
<<<<<<< HEAD:strange-ngpuppies/src/main/java/com/strangengpuppies/strangengpuppies/web/RestContrllers/BillRestController.java

=======
  
>>>>>>> branch-ivelin:strange-ngpuppies/src/main/java/com/strangengpuppies/strangengpuppies/web/RestControllers/BillRestController.java
  @GetMapping ("/nonReady")
  List<Bill> getNonReadyBills() {
    return service.getNonReadyBills();
  }
  
  @GetMapping ("/byID/{id}")
  public Bill getByID(@PathVariable ("id") String id) {
    return service.getBillById(Integer.parseInt(id));
  }
  
  @GetMapping ("/AllBillsStatusAccept")
  public void updateAllBillsStatusAccept() {
    service.updateBillsAccept();
  }
  
  @GetMapping ("/AllBillsStatusCancel")
  public void updateAllBillsStatusCancel() {
    service.updateBillsCancel();
  }
  
  @GetMapping ("/BillStatusAccept/{id}")
  public void updateBillStatusAcceptById(@PathVariable ("id") String id) {
    service.updateBillByIdAccept(Integer.parseInt(id));
  }
  
  @GetMapping ("/BillStatusCancel/{id}")
  public void updateBillStatusCancelById(@PathVariable ("id") String id) {
    service.updateBillByIdCancel(Integer.parseInt(id));
  }
  
  @PostMapping ("/create")
<<<<<<< HEAD:strange-ngpuppies/src/main/java/com/strangengpuppies/strangengpuppies/web/RestContrllers/BillRestController.java
  public void updateBillStatusCancelById(@ModelAttribute("command") FormCommand command, HttpServletResponse response) throws IOException {
    RestTemplate restTemplate = new RestTemplate();
    String url;

    Subscriber tempSubscriber = subscriberService.getByPhonenumber(command.getPhonenumber());


    url = String.format("http://localhost:8080/api/service/byId/%s", command.getDropdownSelectedValue());
    Service serv = restTemplate.getForObject(url,Service.class);
    service.createBill(serv,tempSubscriber,command.getStartDate(),command.getEndDate(),
            Double.parseDouble(command.getBillAmount()),command.getCurrency());

    response.sendRedirect("/admin");
=======
  public void updateBillStatusCancelById(Service product, Subscriber subscriber, String startDate, String endDate, String amount, String currency) throws CurrencyException {
    service.createBill(product, subscriber, startDate, endDate, Double.parseDouble(amount), currency);
>>>>>>> branch-ivelin:strange-ngpuppies/src/main/java/com/strangengpuppies/strangengpuppies/web/RestControllers/BillRestController.java
  }
}
