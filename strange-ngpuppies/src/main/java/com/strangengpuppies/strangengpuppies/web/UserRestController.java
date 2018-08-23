package com.strangengpuppies.strangengpuppies.web;

import com.strangengpuppies.strangengpuppies.model.User;
import com.strangengpuppies.strangengpuppies.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/user")
public class UserRestController {
  
  
  private final UserService service;
  
  @Autowired
  public UserRestController(UserService service) {
    this.service = service;
  }
  
  @GetMapping ("/listAll")
  public List<User> getAll() {
    return service.listAll();
  }
  
  @PostMapping (value = "/updateUser", headers = "Accept=application/json")
  public void updateUser(String id, String username, String password, String eik, String email) {
    service.updateUserById(Integer.parseInt(id), username, password, eik, email);
  }
  
  @PostMapping (value = "/deleteUser/{id}", headers = "Accept=application/json")
  public void updateUser(@PathVariable ("id") String id) {
    service.deleteUserById(Integer.parseInt(id));
  }
  
  @PostMapping (value = "/createClient", headers = "Accept=application/json")
  public void createClient(User client) {
    service.createClient(client.getUsername(), client.getPassword(), client.getEik());
  }
  
  @PostMapping (value = "/createAdministator", headers = "Accept=application/json")
  public void createAdministrator(User admin) {
    service.createAdministrator(admin.getUsername(), admin.getPassword(), admin.getEmail());
  }
}
