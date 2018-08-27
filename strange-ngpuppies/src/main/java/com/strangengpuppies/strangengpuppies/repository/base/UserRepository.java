package com.strangengpuppies.strangengpuppies.repository.base;

import com.strangengpuppies.strangengpuppies.model.User;

import java.util.List;

public interface UserRepository {
  List<User> listAll();
}
