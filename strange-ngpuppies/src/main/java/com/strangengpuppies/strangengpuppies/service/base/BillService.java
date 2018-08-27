package com.strangengpuppies.strangengpuppies.service.base;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.model.Service;
import com.strangengpuppies.strangengpuppies.model.Subscriber;

import java.time.LocalDateTime;
import java.util.List;

public interface BillService {
  List<Bill> getAllBills();
  List<Bill> getReadyBills();
  List<Bill> getNonReadyBills();
  Bill getBillById(int id);
  void createBill(Service service, Subscriber subscriber, LocalDateTime startDate, LocalDateTime endDate, double amount, String currency);
  void updateBillsAccept();
  void updateBillsCancel();
  void updateBillByIdAccept(int id);
  void updateBillByIdCancel(int id);
}
