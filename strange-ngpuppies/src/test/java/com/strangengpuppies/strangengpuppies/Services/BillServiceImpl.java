package com.strangengpuppies.strangengpuppies.Services;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.model.Service;
import com.strangengpuppies.strangengpuppies.model.Subscriber;
import com.strangengpuppies.strangengpuppies.repository.base.BillingRecordRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BillServiceImpl {
  @Mock
  BillingRecordRepository mockRepository;
  @InjectMocks
  com.strangengpuppies.strangengpuppies.service.BillServiceImpl service;
  
  public BillServiceImpl() {
  }
  
  @Test
  public void ListAllBills_Returns_Entities() {
    Mockito.when(this.mockRepository.getAllBills()).thenReturn(Arrays.asList(new Bill(new Service("Television"), new Subscriber(), LocalDate.of(2018, 8, 2), LocalDate.of(2018, 12, 2), 15.0D, "BGN"), new Bill(new Service("Internet"), new Subscriber(), LocalDate.of(2018, 3, 2), LocalDate.of(2019, 12, 5), 15.0D, "BGN"), new Bill(new Service("Phone"), new Subscriber(), LocalDate.of(2017, 5, 2), LocalDate.of(2019, 12, 1), 15.0D, "BGN"), new Bill(new Service("Tv&Phone"), new Subscriber(), LocalDate.of(2017, 8, 2), LocalDate.of(2018, 8, 6), 15.0D, "BGN")));
    List<Bill> result = this.service.getAllBills();
    Assert.assertEquals(4L, (long)result.size());
    Assert.assertEquals("Television", ((Bill)result.get(0)).getService().getName());
    Assert.assertEquals("Internet", ((Bill)result.get(1)).getService().getName());
    Assert.assertEquals("Phone", ((Bill)result.get(2)).getService().getName());
    Assert.assertEquals("Tv&Phone", ((Bill)result.get(3)).getService().getName());
  }
}