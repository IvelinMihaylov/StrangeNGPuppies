package com.strangengpuppies.strangengpuppies.web;

import com.strangengpuppies.strangengpuppies.model.Subscriber;
import com.strangengpuppies.strangengpuppies.model.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    @GetMapping(value = {"/", "/home"})
    public ModelAndView showHome() {
        ModelAndView mav = new ModelAndView("home");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentLoggedUser = authentication.getName();
        RestTemplate restTemplate = new RestTemplate();
        List<Subscriber> top10 = new ArrayList<>();
        try {
            User user = restTemplate.getForObject("http://localhost:8080/api/user/getUserByUsername/" + currentLoggedUser,
                    User.class);
            ResponseEntity<List<Subscriber>> responseEntity = restTemplate.exchange("http://localhost:8080/api/subscriber/getTopTenPayer",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Subscriber>>() {
                    });
            top10 = responseEntity.getBody();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        mav.addObject("top10", top10);
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

