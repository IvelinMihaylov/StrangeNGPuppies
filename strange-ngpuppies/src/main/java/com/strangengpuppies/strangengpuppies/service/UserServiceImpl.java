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
	 if(username.length() > 0) {
	   user.setUsername(username);
	 }
    }
    if(password != null) {
	 if(password.length() > 0) {
	   user.setPassword(password);
	 }
    }
    if(eik != null) {
	 if(eik.length() > 0) {
	   user.setEik(eik);
	 }
    }
    if(email != null) {
	 if(email.length() > 0) {
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
    if(username == null && username.length() == 0) {
	 throw new NullPointerException("Empty username field");
    }
    if(password == null && password.length() == 0) {
	 throw new NullPointerException("Empty password field");
    }
    if(eik == null && eik.length() == 0) {
	 throw new NullPointerException("Empty eik field");
    }
    userRepository.createClient(username, password, eik);
  }
  
  @Override
  public void createAdministrator(String username, String password, String email) {
    if(username == null && username.length() == 0) {
	 throw new NullPointerException("Empty username field");
    }
    if(password == null && password.length() == 0) {
	 throw new NullPointerException("Empty password field");
    }
    if(email == null && email.length() == 0) {
	 throw new NullPointerException("Empty email field");
    }
    userRepository.createAdministrator(username, password, email);
  }
}
