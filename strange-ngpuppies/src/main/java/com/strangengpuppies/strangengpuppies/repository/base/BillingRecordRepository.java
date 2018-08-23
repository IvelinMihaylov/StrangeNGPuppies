package com.strangengpuppies.strangengpuppies.repository.base;

import com.strangengpuppies.strangengpuppies.model.Bill;

import java.util.List;

public interface BillingRecordRepository {
  List<Bill> getAllBills();
  Bill getBillById(int id);
  void updateBills(List<Bill> bills);
  void updateBill(Bill bill);
  
}
