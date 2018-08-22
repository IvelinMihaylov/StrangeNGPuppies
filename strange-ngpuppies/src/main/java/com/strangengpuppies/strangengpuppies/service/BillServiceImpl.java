package com.strangengpuppies.strangengpuppies.service;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.repository.base.BillingRecordRepository;
import com.strangengpuppies.strangengpuppies.service.base.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
  public Bill getBillById(int id) {
    return billRepository.getBillById(id);
  }
}
