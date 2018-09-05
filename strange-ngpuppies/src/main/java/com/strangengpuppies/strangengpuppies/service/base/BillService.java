package com.strangengpuppies.strangengpuppies.service.base;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.model.Service;
import com.strangengpuppies.strangengpuppies.model.Subscriber;

import java.util.List;

public interface BillService {
  List<Bill> getAllBills();
  List<Bill> getReadyBills();
  List<Bill> getNonReadyBills();
  Bill getBillById(int id);
  void createBill(Service service, Subscriber subscriber, String startDate, String endDate, double amount, String currency);
  void updateBillsAccept();
  void updateBillsCancel();
  void updateBillByIdAccept(int id);
  void updateBillByIdCancel(int id);
}
