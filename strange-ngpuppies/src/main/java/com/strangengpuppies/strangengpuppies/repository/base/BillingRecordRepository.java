package com.strangengpuppies.strangengpuppies.repository.base;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.model.Service;
import com.strangengpuppies.strangengpuppies.model.Subscriber;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface BillingRecordRepository {
  List<Bill> getAllBills();
  List<Bill> getReadyBills();
  List<Bill> getNonReadyBills();
  Bill getBillById(int id);
  
  void createBill(Service service, Subscriber subscriber, LocalDate startDate, LocalDate endDate, double amount, String currency);
  void updateBills(List<Bill> bills);
  void updateBill(Bill bill);
  
}
