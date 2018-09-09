package com.strangengpuppies.strangengpuppies.service.base;

import com.strangengpuppies.strangengpuppies.model.User;

import java.util.List;

public interface UserService {
  List<User> listAll();
  
  User getUserById(int id);
  
  void updateUserById(int id, String username, String password, String eik, String email);
  
  void deleteUserById(int id);

  void createClient(String username,String password,String eik);
  void createAdministrator(String username,String password,String email);
  List<User> listAllBanks();

}
