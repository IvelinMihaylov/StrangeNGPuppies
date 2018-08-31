package com.strangengpuppies.strangengpuppies.controllers;

import com.strangengpuppies.strangengpuppies.dao.base.UserDao;
import com.strangengpuppies.strangengpuppies.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView showHome() {
        ModelAndView mav = new ModelAndView("home");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentLoggedUser = authentication.getName();

        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject("http://localhost:8080/api/user/getUserByUsername/"+currentLoggedUser+"", User.class);

        mav.addObject("subs", user.getSubscribers());
        return mav;
    }

    @GetMapping("/admin")
    public ModelAndView showAdmin() {
        ModelAndView mav = new ModelAndView("admin");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange("http://localhost:8080/api/user/listAll", HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        });
        List<User> userList = responseEntity.getBody();
        mav.addObject("users", userList);
        return mav;
    }

}

