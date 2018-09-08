package com.strangengpuppies.strangengpuppies.Services;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.model.Service;
import com.strangengpuppies.strangengpuppies.model.Subscriber;
import com.strangengpuppies.strangengpuppies.model.User;
import com.strangengpuppies.strangengpuppies.repository.base.SubscriberRepository;
import com.strangengpuppies.strangengpuppies.service.Exception.InvalidDateException;
import com.strangengpuppies.strangengpuppies.service.SubscriberServiceImpl;
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

@RunWith (MockitoJUnitRunner.class)
public class SubscriberServiceImplTest {
  @Mock
  SubscriberRepository mockRepository;
  @InjectMocks
  SubscriberServiceImpl service;
  
  @Test
  public void getAllSubscriber_Returns_Entities() {
    // ARRANGE
    Mockito.when(mockRepository.getAllSubscriber()).thenReturn(
		  Arrays.asList(
				new Subscriber("0893544850", "Aleksandar", "Chuchendjiev", "9903027342", new User()),
				new Subscriber("0889944552", "Maria", "Marmalatova", "0105071243", new User()),
				new Subscriber("05478525479", "Minka", "Minkova", "8705228524", new User()),
				new Subscriber("0951231457", "Qnko", "Beleliev", "7612034312", new User())
		  ));
    // ACT
    List<Subscriber> result = this.service.getAllSubscriber();
    // ASSERT
    Assert.assertEquals(4, result.size());
    Assert.assertEquals("0893544850", (result.get(0)).getPhoneNumber());
    Assert.assertEquals("0889944552", (result.get(1)).getPhoneNumber());
    Assert.assertEquals("05478525479", (result.get(2)).getPhoneNumber());
    Assert.assertEquals("0951231457", (result.get(3)).getPhoneNumber());
  }
  
  @Test
  public void getTopTenPayer_Returns_TopTenEntities() {
    // ARRANGE
    Mockito.when(mockRepository.getAllSubscriber()).thenReturn(
		  Arrays.asList(
				new Subscriber("0893544850",
					   "Aleksandar",
					   "Chuchendjiev",
					   "9903027342",
					   new User(),
					   Arrays.asList(new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 10.55, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 14.55, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 15.00, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 12.99, "BGN")
					   )),
				new Subscriber("0889944552",
					   "Maria",
					   "Marmalatova",
					   "0105071243",
					   new User(),
					   Arrays.asList(new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 12.55, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 55.55, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 44.00, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 23.99, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 2.99, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 1.99, "BGN")
					   )),
				new Subscriber("05478525479", "Minka", "Minkova", "8705228524", new User(),
					   Arrays.asList(new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 12.55, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 33.42, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 78.00, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 95.99, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 3.99, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 5.99, "BGN")
					   )),
				new Subscriber("0951231457", "Qnko", "Beleliev", "7612034312", new User(),
					   Arrays.asList(new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 88.55, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 96.87, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 44.04, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 29.99, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 12.99, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.now(), LocalDate.now(), 9.99, "BGN")
					   ))
		  ));
    // ACT
    List<Subscriber> result = this.service.getTopTenPayer();
    // ASSERT
    Assert.assertEquals(10, result.size());
    Assert.assertEquals(96.87, result.get(0).getBills().get(0).getAmount(), 0.001);
    Assert.assertEquals(95.99d, result.get(1).getBills().get(0).getAmount(), 0.001);
    Assert.assertEquals(88.55d, result.get(2).getBills().get(0).getAmount(), 0.001);
    Assert.assertEquals(78.00d, result.get(3).getBills().get(0).getAmount(), 0.001);
    Assert.assertEquals(55.55d, result.get(4).getBills().get(0).getAmount(), 0.001);
    Assert.assertEquals(44.04d, result.get(5).getBills().get(0).getAmount(), 0.001);
    Assert.assertEquals(44.00d, result.get(6).getBills().get(0).getAmount(), 0.001);
    Assert.assertEquals(33.42d, result.get(7).getBills().get(0).getAmount(), 0.001);
    Assert.assertEquals(29.99d, result.get(8).getBills().get(0).getAmount(), 0.001);
    Assert.assertEquals(23.99d, result.get(9).getBills().get(0).getAmount(), 0.001);
  }
  
  @Test
  public void getTopTenLastPaymentr_Returns_TopTenEntities() {
    // ARRANGE
    Mockito.when(mockRepository.getAllSubscriber()).thenReturn(
		  Arrays.asList(
				new Subscriber("0893544850",
					   "Aleksandar",
					   "Chuchendjiev",
					   "9903027342",
					   new User(),
					   Arrays.asList(
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2012, 02, 02), LocalDate.of(2013, 02, 03), 10.55, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2012, 02, 02), LocalDate.of(2013, 02, 03), 14.55, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2013, 02, 02), LocalDate.of(2014, 02, 02), 15.00, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2014, 02, 02), LocalDate.of(2015, 02, 02), 12.99, "BGN")
					   )),
				new Subscriber("0889944552",
					   "Maria",
					   "Marmalatova",
					   "0105071243",
					   new User(),
					   Arrays.asList(
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2014, 03, 03), LocalDate.of(2015, 03, 03), 12.55, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2015, 03, 03), LocalDate.of(2016, 03, 03), 55.55, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2015, 03, 03), LocalDate.of(2017, 03, 03), 44.00, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2015, 03, 03), LocalDate.of(2016, 04, 03), 23.99, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2015, 03, 03), LocalDate.of(2010, 05, 12), 2.99, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2012, 03, 03), LocalDate.of(2015, 03, 06), 1.99, "BGN")
					   )),
				new Subscriber("05478525479", "Minka", "Minkova", "8705228524", new User(),
					   Arrays.asList(
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2015, 03, 03), LocalDate.of(2018, 03, 03), 33.42, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2015, 03, 03), LocalDate.of(2018, 04, 03), 78.00, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2015, 03, 03), LocalDate.of(2018, 05, 03), 95.99, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2015, 03, 03), LocalDate.of(2018, 06, 03), 3.99, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2015, 03, 03), LocalDate.of(2018, 07, 03), 5.99, "BGN")
					   )),
				new Subscriber("0951231457", "Qnko", "Beleliev", "7612034312", new User(),
					   Arrays.asList(
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2015, 03, 03), LocalDate.of(2018, 07, 03), 96.87, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2012, 03, 03), LocalDate.of(2018, 07, 23), 44.04, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2013, 03, 03), LocalDate.of(2018, 07, 24), 29.99, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2011, 03, 03), LocalDate.of(2018, 07, 25), 12.99, "BGN"),
							 new Bill(new Service(), new Subscriber(), LocalDate.of(2017, 03, 03), LocalDate.of(2018, 07, 29), 9.99, "BGN")
					   ))
		  ));
    // ACT
    List<Subscriber> result = this.service.getTopTenLastPayment();
    // ASSERT
    Assert.assertEquals(10, result.size());
    Assert.assertEquals(LocalDate.of(2018, 07, 29), result.get(0).getBills().get(0).getEndDate());
    Assert.assertEquals(LocalDate.of(2018, 07, 25), result.get(1).getBills().get(0).getEndDate());
    Assert.assertEquals(LocalDate.of(2018, 07, 24), result.get(2).getBills().get(0).getEndDate());
    Assert.assertEquals(LocalDate.of(2018, 07, 23), result.get(3).getBills().get(0).getEndDate());
    Assert.assertEquals(LocalDate.of(2018, 07, 03), result.get(4).getBills().get(0).getEndDate());
    Assert.assertEquals(LocalDate.of(2018, 07, 03), result.get(5).getBills().get(0).getEndDate());
    Assert.assertEquals(LocalDate.of(2018, 06, 03), result.get(6).getBills().get(0).getEndDate());
    Assert.assertEquals(LocalDate.of(2018, 05, 03), result.get(7).getBills().get(0).getEndDate());
    Assert.assertEquals(LocalDate.of(2018, 04, 03), result.get(8).getBills().get(0).getEndDate());
    Assert.assertEquals(LocalDate.of(2018, 03, 03), result.get(9).getBills().get(0).getEndDate());
  }
  
  @Test
  public void getTopTenLastPayment_Returns_Entity() {
    // ARRANGE
    Mockito.when(mockRepository.getById("0893544850")).thenReturn(
		  
		  new Subscriber("0893544850",
				"Aleksandar",
				"Chuchendjiev",
				"9903027342",
				new User())
    );
    // ACT
    Subscriber result = this.service.getByPhonenumber("0893544850");
    // ASSERT
    Assert.assertEquals("0893544850", result.getPhoneNumber());
  }
  
  @Test
  public void createSubscriber_Create_New_Entity() throws InvalidDateException {
    // ACT
    service.createSubscriber("0893544850", "Ivelin", "Mihaylov", "9604081485");
    // ASSERT
    Mockito.verify(mockRepository).createSubscriber("0893544850", "Ivelin", "Mihaylov", "9604081485");
  }
  
  @Test
  public void updateSubscriberByPhonenumber_Update_Entity() {
    // ARRANGE
    Subscriber subscriber = new Subscriber("0893544850", "Ivelin", "Mihaylov", "9604081485", new User());
    Mockito.when(mockRepository.getById("0893544850")).thenReturn(subscriber);
    // ACT
    service.updateSubscriberByPhonenumber("0893544850", "0993544850", "Ivelin", "Mihaylov", "9604081485");
    // ASSERT
    Mockito.verify(mockRepository).updateSubscriber(subscriber);
  }
  
  @Test
  public void deleteSubscriberByPhonenumber_Delete_Entity() {
    // ARRANGE
    Subscriber subscriber = new Subscriber("0893544850", "Ivelin", "Mihaylov", "9604081485", new User());
    Mockito.when(mockRepository.getById("0893544850")).thenReturn(subscriber);
    // ACT
    service.deleteSubscriberByPhonenumber("0893544850");
    // ASSERT
    Mockito.verify(mockRepository).deleteSubscriber(subscriber);
  }
}
