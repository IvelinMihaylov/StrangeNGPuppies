package com.strangengpuppies.strangengpuppies.web.RestContrllers;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.model.Service;
import com.strangengpuppies.strangengpuppies.model.Subscriber;
import com.strangengpuppies.strangengpuppies.service.base.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping ("api/bill")
public class BillRestController {
  
  private final BillService service;
  
  @Autowired
  public BillRestController(BillService service) {
    this.service = service;
  }
  
  @GetMapping ("/listAll")
  public List<Bill> getAll() {
    return service.getAllBills();
  }
  
  @GetMapping ("/history")
  List<Bill> getReadyBills(){
    return service.getReadyBills();
  }
  @GetMapping ("/nonReady")
  List<Bill> getNonReadyBills(){
    return service.getNonReadyBills();
  }

  @GetMapping ("/byID/{id}")
  public Bill getByID(@PathVariable("id") String id) {
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
  public void updateBillStatusAcceptById(@PathVariable("id") String id) {
     service.updateBillByIdAccept(Integer.parseInt(id));
  }
  
  @GetMapping ("/BillStatusCancel/{id}")
  public void updateBillStatusCancelById(@PathVariable("id") String id) {
     service.updateBillByIdCancel(Integer.parseInt(id));
  }
  
  @PostMapping ("/create")
  public void updateBillStatusCancelById(Service product, Subscriber subscriber, LocalDateTime startDate, LocalDateTime endDate, String amount, String currency) {
    service.createBill(product,subscriber,startDate,endDate,Double.parseDouble(amount),currency);
  }
}
