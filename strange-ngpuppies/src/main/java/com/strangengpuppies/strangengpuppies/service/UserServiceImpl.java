package com.strangengpuppies.strangengpuppies.service;

import com.strangengpuppies.strangengpuppies.model.User;
import com.strangengpuppies.strangengpuppies.repository.base.UserRepository;
import com.strangengpuppies.strangengpuppies.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  
  private final UserRepository userRepository;
  
  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  
  
  @Override
  public List<User> listAll() {
    return userRepository.listAll();
  }
  
  @Override
  public User getUserById(int id) {
    return userRepository.getUserById(id);
  }
  
  @Override
  public void updateUserById(int id, String username, String password, String eik, String email) {
    User user = userRepository.getUserById(id);
    
    if(username != null) {
	 if (username.length() > 0){
	   user.setUsername(username);
	 }
    }
    if(password != null) {
	 if (password.length() > 0) {
	   user.setPassword(password);
	 }
    }
    if(eik != null) {
	 if (eik.length() > 0) {
	   user.setEik(eik);
	 }
    }
    if(email != null) {
	 if (email.length()>0) {
	   user.setEmail(email);
	 }
    }
    userRepository.updateUser(user);
  }
  
  @Override
  public void deleteUserById(int id) {
    User user = userRepository.getUserById(id);
    userRepository.deleteUser(user);
  }
  
  @Override
  public void createClient(String username, String password, String eik) {
    if(username != null && password != null && eik != null && username.length() > 0 && password.length() > 0 && eik.length() > 0) {
	 userRepository.createClient(username, password, eik);
    }else {
	 System.out.println("Incorrect data for create client.");
    }
  }
  
  @Override
  public void createAdministrator(String username, String password, String email) {
    if(username != null || password != null || email != null && username.length() > 0 && password.length() > 0 && email.length() > 0) {
	 userRepository.createAdministrator(username, password, email);
    }else {
	 System.out.println("Incorrect data for create admin.");
    }
    
  }
}
