package com.strangengpuppies.strangengpuppies.dao.base;

import com.strangengpuppies.strangengpuppies.model.User;

public interface UserDao {
    User finUserByUsername(String username);
}
