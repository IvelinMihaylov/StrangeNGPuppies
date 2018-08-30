package com.strangengpuppies.strangengpuppies.controllers;

import com.strangengpuppies.strangengpuppies.dao.base.UserDao;
import com.strangengpuppies.strangengpuppies.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/")
    public ModelAndView showHome() {
        ModelAndView mav = new ModelAndView("home");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentLoggedUser = authentication.getName();
        User user = userDao.findUserByUsername(currentLoggedUser);

        mav.addObject("subs", user.getSubscribers());
        return mav;
    }

    @GetMapping("/admin")
    public String showAdmin() {
        return "admin";
    }

}

