package com.strangengpuppies.strangengpuppies.Services;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.model.Service;
import com.strangengpuppies.strangengpuppies.model.Subscriber;
import com.strangengpuppies.strangengpuppies.repository.base.BillingRecordRepository;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RunWith (MockitoJUnitRunner.class)
public class BillServiceImplTest {
  @Mock
  BillingRecordRepository mockRepository;
  @InjectMocks
  com.strangengpuppies.strangengpuppies.service.BillServiceImpl service;
  
  public BillServiceImplTest() {
  }
  
  @Test
  public void ListAllBills_Returns_Entities() {
    Mockito.when(
		  this.mockRepository.getAllBills())
		  .thenReturn(Arrays.asList(
				new Bill(new Service("Television"), new Subscriber(), LocalDate.of(2018, 8, 2), LocalDate.of(2018, 12, 2), 15.0, "BGN"),
				new Bill(new Service("Internet"), new Subscriber(), LocalDate.of(2018, 3, 2), LocalDate.of(2019, 12, 5), 15.0, "BGN"),
				new Bill(new Service("Phone"), new Subscriber(), LocalDate.of(2017, 5, 2), LocalDate.of(2019, 12, 1), 15.0, "BGN"),
				new Bill(new Service("Tv&Phone"), new Subscriber(), LocalDate.of(2017, 8, 2), LocalDate.of(2018, 8, 6), 15.0, "BGN")));
    List<Bill> result = this.service.getAllBills();
    Assert.assertEquals(4, result.size());
    Assert.assertEquals("Television", (result.get(0)).getService().getName());
    Assert.assertEquals("Internet", (result.get(1)).getService().getName());
    Assert.assertEquals("Phone", (result.get(2)).getService().getName());
    Assert.assertEquals("Tv&Phone", (result.get(3)).getService().getName());
  }
  
  @Test
  public void getReadyBills_Returns_Entities() {
    Mockito.when(
		  this.mockRepository.getReadyBills())
		  .thenReturn(Arrays.asList(
				new Bill(new Service("Television"), new Subscriber(), LocalDate.of(2018, 8, 2), LocalDate.of(2018, 12, 2), 15.0, "BGN","approved"),
				new Bill(new Service("Internet"), new Subscriber(), LocalDate.of(2018, 3, 2), LocalDate.of(2019, 12, 5), 15.0, "BGN","approved"),
				new Bill(new Service("Phone"), new Subscriber(), LocalDate.of(2017, 5, 2), LocalDate.of(2019, 12, 1), 15.0, "BGN","approved"),
				new Bill(new Service("Tv&Phone"), new Subscriber(), LocalDate.of(2017, 8, 2), LocalDate.of(2018, 8, 6), 15.0, "BGN","approved")));
    List<Bill> result = this.service.getReadyBills();
    Assert.assertEquals(4, result.size());
    Assert.assertEquals("approved", (result.get(0)).getStatus());
    Assert.assertEquals("approved", (result.get(1)).getStatus());
    Assert.assertEquals("approved", (result.get(2)).getStatus());
    Assert.assertEquals("approved", (result.get(3)).getStatus());
  }
  
  @Test
  public void getNonReadyBills_Returns_Entities() {
    Mockito.when(
		  this.mockRepository.getNonReadyBills())
		  .thenReturn(Arrays.asList(
				new Bill(new Service("Television"), new Subscriber(), LocalDate.of(2018, 8, 2), LocalDate.of(2018, 12, 2), 15.0, "BGN","waiting"),
				new Bill(new Service("Internet"), new Subscriber(), LocalDate.of(2018, 3, 2), LocalDate.of(2019, 12, 5), 15.0, "BGN","waiting"),
				new Bill(new Service("Phone"), new Subscriber(), LocalDate.of(2017, 5, 2), LocalDate.of(2019, 12, 1), 15.0, "BGN","waiting"),
				new Bill(new Service("Tv&Phone"), new Subscriber(), LocalDate.of(2017, 8, 2), LocalDate.of(2018, 8, 6), 15.0, "BGN","waiting")));
    List<Bill> result = this.service.getNonReadyBills();
    Assert.assertEquals(4, result.size());
    Assert.assertEquals("waiting", (result.get(0)).getStatus());
    Assert.assertEquals("waiting", (result.get(1)).getStatus());
    Assert.assertEquals("waiting", (result.get(2)).getStatus());
    Assert.assertEquals("waiting", (result.get(3)).getStatus());
  }
  
  @Test
  public void getBillById_Returns_Entity() {
    Mockito.when(
		  this.mockRepository.getBillById(11))
		  .thenReturn(
				new Bill(new Service("Television"), new Subscriber(), LocalDate.of(2018, 8, 2), LocalDate.of(2018, 12, 2), 15.0, "BGN","waiting"));
    Bill result = this.service.getBillById(11);
    Assert.assertEquals(0, result.getId());
    Assert.assertEquals("Television", result.getService().getName());
    
  }
  @Test @Ignore
  public void createBill_Returns_Entity() {
  
//    	Mockito.doNothing().(this.service.createBill(new Service("Television"),
//		   new Subscriber(), "2017-08-02", "2018-08-06", 15.0, "BGN"));
//  	Mockito.validateMockitoUsage();
//    this.service.createBill(new Service("Television"), new Subscriber(), "2017-08-02", "2018-08-06", 15.0, "BGN");
  
  }
  
  @Test @Ignore
  public void updateBills_Update_Entities_With_AcceptStatus() {
  
  }
  
  @Test @Ignore
  public void updateBills_Update_Entities_With_CancelStatus() {
  
  }
  
  @Test @Ignore
  public void updateBill_Update_Entity_With_AcceptStatus() {
  
  }
  
  @Test @Ignore
  public void updateBill_Update_Entity_With_CancelStatus() {
  
  }
}