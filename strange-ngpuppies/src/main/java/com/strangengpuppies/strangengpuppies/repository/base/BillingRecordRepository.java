package com.strangengpuppies.strangengpuppies.repository.base;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.model.Service;
import com.strangengpuppies.strangengpuppies.model.Subscriber;

import java.util.List;

public interface BillingRecordRepository {
  List<Bill> getAllBills();
  Bill getBillById(int id);
  void createBill(Service service, Subscriber subscriber, String startDate, String endDate, double amount, String currency);
  void updateBills(List<Bill> bills);
  void updateBill(Bill bill);
}
