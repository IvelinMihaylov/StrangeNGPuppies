package com.strangengpuppies.strangengpuppies.controllers;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.model.Subscriber;
import com.strangengpuppies.strangengpuppies.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/subscribers")
    public ModelAndView showSubscribers(){
        ModelAndView mav = new ModelAndView("subscribers");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentLoggedUser = authentication.getName();

        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject("http://localhost:8080/api/user/getUserByUsername/"+currentLoggedUser+"", User.class);

        mav.addObject("subs", user.getSubscribers());

        return mav;
    }

    @GetMapping("/billsHistory")
    public ModelAndView showBillsHistory(){
        ModelAndView mav = new ModelAndView("billsHistory");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentLoggedUser = authentication.getName();

        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject("http://localhost:8080/api/user/getUserByUsername/"+currentLoggedUser+"", User.class);
        List<Bill> bills = new ArrayList<>();
        if (user.getSubscribers().isEmpty()) return mav;
        for (Subscriber sub: user.getSubscribers()) {
            bills.addAll(sub.getBills());
        }
        mav.addObject("bills", bills);
        return mav;
    }
}
