package com.strangengpuppies.strangengpuppies.repository.base;

import com.strangengpuppies.strangengpuppies.model.User;

import java.util.List;

public interface UserRepository {
  
  List<User> listAll();
  
  User getUserById(int id);
  
  void updateUser(User user);
  
  void deleteUser(User user);
  
  void createClient(String username, String password, String eik);
  
  void createAdministrator(String username, String password, String email);

  List<User> listAllBanks();
}
