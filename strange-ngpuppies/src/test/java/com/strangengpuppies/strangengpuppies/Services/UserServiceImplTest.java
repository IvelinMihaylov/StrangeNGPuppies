package com.strangengpuppies.strangengpuppies.Services;

import com.strangengpuppies.strangengpuppies.model.Role;
import com.strangengpuppies.strangengpuppies.model.User;
import com.strangengpuppies.strangengpuppies.repository.base.UserRepository;
import com.strangengpuppies.strangengpuppies.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith (MockitoJUnitRunner.class)
public class UserServiceImplTest {
  
  @Mock
  UserRepository mockRepository;
  @InjectMocks
  UserServiceImpl service;
  
  @Test
  public void listAll_Returns_Entities() {
    Mockito.when(mockRepository.listAll()).thenReturn(
    	   Arrays.asList(
		  new User("panda", "panda123", "pandapower@gmail.com", null, new Role("ADMIN")),
		  new User("lion", "lion123", "lionpower@gmail.com", null, new Role("ADMIN")),
		  new User("cat", "cat123", "catpower@gmail.com", null, new Role("ADMIN"))
	   ));
   List<User> result = service.listAll();
    Assert.assertEquals("panda",result.get(0).getUsername());
    Assert.assertEquals("lion",result.get(1).getUsername());
    Assert.assertEquals("cat",result.get(2).getUsername());
  }
  
  @Test
  public void getUserById_Returns_Entities() {
    Mockito.when(mockRepository.getUserById(1)).thenReturn(
		  new User("panda", "panda123", "pandapower@gmail.com", null, new Role("ADMIN")
		  ));
    User result = service.getUserById(1);
    Assert.assertEquals("panda",result.getUsername());
  }
  
  @Test @Ignore
  public void updateUserById_Update_Entity() {
  }
  
  @Test @Ignore
  public void deleteUserById_Delete_Entity() {
  }
  
  @Test @Ignore
  public void createClient_Create_New_Client_Entity() {
  }
  @Test @Ignore
  public void createAdministrator_Create_New_Admin_Entity() {
  }
}
