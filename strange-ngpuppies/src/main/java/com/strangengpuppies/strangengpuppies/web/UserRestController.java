package com.strangengpuppies.strangengpuppies.web;

import com.strangengpuppies.strangengpuppies.model.User;
import com.strangengpuppies.strangengpuppies.service.MyUserDetailsService;
import com.strangengpuppies.strangengpuppies.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserRestController {


  private UserService service;

  @Autowired
  public UserRestController(UserService service){
    this.service = service;
  }

  @GetMapping("/all")
    public List<User> getAll(){
      return service.listAll();
  }

}
