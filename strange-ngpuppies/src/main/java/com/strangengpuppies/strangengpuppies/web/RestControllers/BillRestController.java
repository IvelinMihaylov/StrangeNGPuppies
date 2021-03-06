package com.strangengpuppies.strangengpuppies.web.RestControllers;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.model.Service;
import com.strangengpuppies.strangengpuppies.model.Subscriber;
import com.strangengpuppies.strangengpuppies.model.formControl.FormCommand;

import com.strangengpuppies.strangengpuppies.service.Exception.CurrencyException;
import com.strangengpuppies.strangengpuppies.service.base.BillService;
import com.strangengpuppies.strangengpuppies.service.base.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

  @GetMapping("/listAll")
  public List<Bill> getAll() {
    return service.getAllBills();
  }

  @GetMapping("/history")
  List<Bill> getReadyBills() {
    return service.getReadyBills();
  }

  @GetMapping("/nonReady")
  List<Bill> getNonReadyBills() {
    return service.getNonReadyBills();
  }

  @GetMapping("/byID/{id}")
  public Bill getByID(@PathVariable("id") String id) {
    return service.getBillById(Integer.parseInt(id));
  }

  @GetMapping("/AllBillsStatusAccept")
  public void updateAllBillsStatusAccept() {
    service.updateBillsAccept();
  }

  @GetMapping("/AllBillsStatusCancel")
  public void updateAllBillsStatusCancel() {
    service.updateBillsCancel();
  }

  @GetMapping("/BillStatusAccept/{id}")
  public void updateBillStatusAcceptById(@PathVariable("id") String id) {
    service.updateBillByIdAccept(Integer.parseInt(id));
  }

  @GetMapping("/BillStatusCancel/{id}")
  public void updateBillStatusCancelById(Service product, Subscriber subscriber, String startDate, String endDate, String amount, String currency) throws CurrencyException {
    service.createBill(product, subscriber, startDate, endDate, Double.parseDouble(amount), currency);
  }

  @PostMapping("/create")
  public void updateBillStatusCancelById(@ModelAttribute("command") FormCommand command, HttpServletResponse response) throws IOException, CurrencyException {
    RestTemplate restTemplate = new RestTemplate();
    String url;

    Subscriber tempSubscriber = subscriberService.getByPhonenumber(command.getPhonenumber());


    url = String.format("http://localhost:8080/api/service/byId/%s", command.getDropdownSelectedValue());
    Service serv = restTemplate.getForObject(url, Service.class);
    service.createBill(serv, tempSubscriber, command.getStartDate(), command.getEndDate(),
            Double.parseDouble(command.getBillAmount()), command.getCurrency());

    response.sendRedirect("/admin");

  }
}
