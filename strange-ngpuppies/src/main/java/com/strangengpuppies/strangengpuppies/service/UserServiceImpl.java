package com.strangengpuppies.strangengpuppies.service;

import com.strangengpuppies.strangengpuppies.model.User;
import com.strangengpuppies.strangengpuppies.repository.base.UserRepository;
import com.strangengpuppies.strangengpuppies.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  
  private UserRepository userRepository;
  
  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  
  
  @Override
  public List<User> listAll() {
    return userRepository.listAll();
  }
  
  @Override
  public void updateUserById(int id, String username, String password, String eik, String email) {
    User user = userRepository.getUserById(id);
    
    if(username != null) {
	 user.setUsername(username);
    }
    if(password != null) {
	 user.setPassword(password);
    }
    if(eik != null) {
	 user.setEik(eik);
    }
    if(email != null) {
	 user.setEmail(email);
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
    userRepository.createClient(username, password, eik);
  }
  
  @Override
  public void createAdministrator(String username, String password, String email) {
    userRepository.createAdministrator(username, password, email);
  }
}
