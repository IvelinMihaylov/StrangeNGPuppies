package com.strangengpuppies.strangengpuppies.web.RestContrllers;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.service.base.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
