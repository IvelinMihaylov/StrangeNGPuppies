package com.strangengpuppies.strangengpuppies.service.base;

import com.strangengpuppies.strangengpuppies.model.User;

import java.util.List;

public interface UserService {
  List<User> listAll();
  void createClient(String username,String password,String eik);
  void createAdministrator(String username,String password,String email);
}
