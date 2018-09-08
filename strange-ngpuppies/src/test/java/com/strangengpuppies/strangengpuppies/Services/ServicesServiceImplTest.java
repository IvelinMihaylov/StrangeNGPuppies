package com.strangengpuppies.strangengpuppies.Services;

import com.strangengpuppies.strangengpuppies.service.ServicesServiceImpl;
import com.strangengpuppies.strangengpuppies.model.Service;
import com.strangengpuppies.strangengpuppies.repository.base.ServiceRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith (MockitoJUnitRunner.class)
public class ServicesServiceImplTest {
  @Mock
  ServiceRepository mockRepository;
  @InjectMocks
  ServicesServiceImpl service;
  
  public ServicesServiceImplTest() {
  }
  
  @Test
  public void getAllService_Returns_Entities() {
    // ARRANGE
    Mockito.when(mockRepository.getAllService()).thenReturn(
		  Arrays.asList(
				new Service("Television"),
				new Service("Internet"),
				new Service("Phone"),
				new Service("Tv&Phone")
		  ));
    // ACT
    List<Service> result = this.service.getAllService();
    // ASSERT
    Assert.assertEquals(4, result.size());
    Assert.assertEquals("Television", (result.get(0)).getName());
    Assert.assertEquals("Internet", (result.get(1)).getName());
    Assert.assertEquals("Phone", (result.get(2)).getName());
    Assert.assertEquals("Tv&Phone", (result.get(3)).getName());
  }
  
  @Test
  public void getServiceByID_Returns_Entity() {
    // ARRANGE
    Mockito.when(mockRepository.getServiceByID(1)).thenReturn(new Service("Television"));
    // ACT
    Service result = this.service.getServiceByID(1);
    // ASSERT
    Assert.assertEquals("Television", result.getName());
  }
  
  @Test
  public void createService_Create_New_Entity() {
    // ACT
    service.createService("Television");
    // ASSERT
    Mockito.verify(mockRepository).createService("Television");
  }
  
  @Test
  public void updateService_Update_Entity() {
    // ACT
    service.updateService(0, "Phone");
    // ASSERT
    Mockito.verify(mockRepository).updateService(0, "Phone");
  }
  
  @Test
  public void deleteService_Delete_Entity() {
    // ACT
    service.deleteService(0);
    // ASSERT
    Mockito.verify(mockRepository).deleteService(0);
  }
}
