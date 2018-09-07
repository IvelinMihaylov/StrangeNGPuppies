package com.strangengpuppies.strangengpuppies.controllers;

import com.strangengpuppies.strangengpuppies.model.formControl.FormCommand;
import com.strangengpuppies.strangengpuppies.service.base.SubscriberService;
import com.strangengpuppies.strangengpuppies.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    private final SubscriberService subscriberService;
    private final UserService userService;

    @Autowired
    public AdminController(SubscriberService subscriberService, UserService userService) {
        this.subscriberService = subscriberService;
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

    @PostMapping("/createSubscriberForm")
    public String createSubscriber(@ModelAttribute("command")FormCommand command,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "redirect:/admin";
        }
        subscriberService.createSubscriber(command.getPhonenumber(), command.getFirstName(), command.getLastName(), command.getEgn());
        return "redirect:/admin";
    }
}
