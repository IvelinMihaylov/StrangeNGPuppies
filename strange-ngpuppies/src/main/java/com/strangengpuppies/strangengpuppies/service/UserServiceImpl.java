package com.strangengpuppies.strangengpuppies.service;

import com.strangengpuppies.strangengpuppies.repository.base.UserRepository;
import com.strangengpuppies.strangengpuppies.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
  
  private final UserRepository userRepository;
  
  @Autowired
  public UserServiceImpl(UserRepository userRepository){
    this.userRepository = userRepository;
  }
  
  
  @Override
  public List<User> listAll() {
    return userRepository.listAll();
  }
}
