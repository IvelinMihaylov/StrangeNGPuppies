package com.strangengpuppies.strangengpuppies.web.RestContrllers;

import com.strangengpuppies.strangengpuppies.dao.base.UserDao;
import com.strangengpuppies.strangengpuppies.model.User;
import com.strangengpuppies.strangengpuppies.model.formControl.FormCommand;
import com.strangengpuppies.strangengpuppies.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping ( value = "api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {
  
  
  private final UserService service;
  private final UserDao userDao;
  
  @Autowired
  public UserRestController(UserService service, UserDao userDao) {
    this.service = service;
    this.userDao = userDao;
  }
  
  @GetMapping ("/listAll")
  public List<User> getAll() {
    return service.listAll();
  }

  @GetMapping("/listAllBanks")
  public List<User> listAllBanks() {
    return service.listAllBanks();
  }

  @GetMapping("/getUserByUsername/{username}")
  public User getUserByUsername(@PathVariable String username) {
      return userDao.findUserByUsername(username);
  }

  @PostMapping (value = "/updateUser", headers = "Accept=application/json")
  public void updateUser(@ModelAttribute("command") FormCommand command, HttpServletResponse response) {
    service.updateUserById(Integer.parseInt(command.getEgn()), command.getUsernameField(), command.getPasswordField(), command.getEIK(), command.getEmailField());
  }
  
  @PostMapping (value = "/deleteUser/{id}", headers = "Accept=application/json")
  public void updateUser(@PathVariable ("id") String id) {
    service.deleteUserById(Integer.parseInt(id));
  }
  
  @GetMapping (value = "/createClient")
  public void createClient(@ModelAttribute("command") FormCommand command, HttpServletResponse response) throws IOException {
      service.createClient(command.getUsernameField(), command.getPasswordField(), command.getEIK());
      response.sendRedirect("/admin");
  }
  
  @PostMapping (value = "/createAdministrator", headers = "Accept=application/json")
  public void createAdministrator(@ModelAttribute("command") FormCommand command, HttpServletResponse response) throws IOException {
    service.createAdministrator(command.getUsernameField(), command.getPasswordField(), command.getEmailField());
    response.sendRedirect("/admin");
  }
}
