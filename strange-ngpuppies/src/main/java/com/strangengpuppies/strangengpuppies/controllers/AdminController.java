package com.strangengpuppies.strangengpuppies.controllers;

import com.strangengpuppies.strangengpuppies.model.User;
import com.strangengpuppies.strangengpuppies.model.formControl.FormCommand;
import com.strangengpuppies.strangengpuppies.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
public class AdminController {


    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/createClient")
    public ModelAndView showCreateClientForm() {
        ModelAndView mav = new ModelAndView("adminCreateClient");
        mav.addObject("command", new FormCommand());
        return mav;
    }

    @GetMapping("/createAdmin")
    public ModelAndView showCreateAdminForm(){
        ModelAndView mav = new ModelAndView("adminCreateAdmin");
        mav.addObject("command", new FormCommand());
        return mav;
    }

    @GetMapping("/createSubscriber")
    public ModelAndView showCreateSubscriberForm(){
        ModelAndView mav = new ModelAndView("adminCreateSubscriber");
        mav.addObject("command", new FormCommand());
        return mav;
    }

    @PostMapping("/createClientForm")
    public String createClient(@ModelAttribute("command")FormCommand command,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "redirect:/admin";
        }
        userService.createClient(command.getUsernameField(), command.getPasswordField(), command.getEIK());
        return "redirect:/admin";
    }
    @PostMapping("/createAdminForm")
    public String createAdmin(@ModelAttribute("command")FormCommand command,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "redirect:/admin";
        }
        userService.createAdministrator(command.getUsernameField(), command.getPasswordField(), command.getEmailField());
        return "redirect:/admin";
    }
}
