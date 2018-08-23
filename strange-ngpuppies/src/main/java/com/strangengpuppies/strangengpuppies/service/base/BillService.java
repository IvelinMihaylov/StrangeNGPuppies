package com.strangengpuppies.strangengpuppies.service.base;

import com.strangengpuppies.strangengpuppies.model.Bill;

import java.util.List;

public interface BillService {
  List<Bill> getAllBills();
  Bill getBillById(int id);
  void updateBillsAccept();
  void updateBillsCancel();
  void updateBillByIdAccept(int id);
  void updateBillByIdCancel(int id);
}
