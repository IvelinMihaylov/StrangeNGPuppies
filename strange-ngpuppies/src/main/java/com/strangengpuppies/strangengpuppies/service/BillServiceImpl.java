package com.strangengpuppies.strangengpuppies.service;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.model.Subscriber;
import com.strangengpuppies.strangengpuppies.repository.base.BillingRecordRepository;
import com.strangengpuppies.strangengpuppies.service.base.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@Service
public class BillServiceImpl implements BillService {
  
  private final BillingRecordRepository billRepository;
  
  @Autowired
  public BillServiceImpl(BillingRecordRepository billRepository){
    this.billRepository = billRepository;
  }
  
  @Override
  public List<Bill> getAllBills() {
    return billRepository.getAllBills();
  }
  
  @Override
  public List<Bill> getReadyBills() {
    return billRepository.getReadyBills();
  }
  
  @Override
  public List<Bill> getNonReadyBills() {
    return billRepository.getNonReadyBills();
  }
  
  @Override
  public Bill getBillById(int id) {
    return billRepository.getBillById(id);
  }
  
  @Override
  public void createBill(com.strangengpuppies.strangengpuppies.model.Service service, Subscriber subscriber, LocalDateTime startDate, LocalDateTime endDate, double amount, String currency) {
    HashSet<String> listOfCurrencies= new HashSet<>();
    listOfCurrencies.add("USD");
    listOfCurrencies.add("EUR");
    listOfCurrencies.add("GBP");
    listOfCurrencies.add("RUB");
    listOfCurrencies.add("BGN");
    
    if(!listOfCurrencies.contains(currency)){
      System.out.println("incorrect currency");
    }else {
      billRepository.createBill(service, subscriber, startDate, endDate, amount, currency);
    }
  }
  
  @Override
  public void updateBillsAccept() {
    List<Bill> bills = billRepository.getAllBills();
    for(Bill bill: bills) {
      bill.setStatus("approved");
    }
    billRepository.updateBills(bills);
  }
  
  @Override
  public void updateBillsCancel() {
    List<Bill> bills = billRepository.getAllBills();
    for(Bill bill: bills) {
      bill.setStatus("refused");
    }
    billRepository.updateBills(bills);
  }
  
  @Override
  public void updateBillByIdAccept(int id) {
  Bill bill = billRepository.getBillById(id);
  bill.setStatus("approved");
  billRepository.updateBill(bill);
  }
  
  @Override
  public void updateBillByIdCancel(int id) {
    Bill bill = billRepository.getBillById(id);
    bill.setStatus("refused");
    billRepository.updateBill(bill);
  }
  
}
