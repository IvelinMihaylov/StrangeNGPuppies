package com.strangengpuppies.strangengpuppies.controllers;

import com.strangengpuppies.strangengpuppies.model.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping(value = {"/", "/home"})
    public ModelAndView showHome() {
        return new ModelAndView("home");
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

