package com.strangengpuppies.strangengpuppies.controllers;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.model.Subscriber;
import com.strangengpuppies.strangengpuppies.model.User;
import com.strangengpuppies.strangengpuppies.model.formControl.FormCommand;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
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

    @GetMapping("/payBills/{phonenumber}")
    public ModelAndView showSubBills(@PathVariable("phonenumber") String phonenumber) {
        ModelAndView mav = new ModelAndView("payBill");
        RestTemplate restTemplate = new RestTemplate();
        Subscriber subscriber = restTemplate.getForObject("http://localhost:8080/api/subscriber/byID/"+ phonenumber, Subscriber.class);
        mav.addObject("command", new FormCommand());
        mav.addObject("bills", subscriber.getBills());
        return mav;
    }

    @GetMapping(value = "/paybillsform")
    public String payBills(@ModelAttribute("command") FormCommand command,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            return "redirect:/billsHistory";
        }
        redirectAttributes.addFlashAttribute("command", command);
        RestTemplate restTemplate = new RestTemplate();

        for (String strId: command.getMultiCheckboxSelectedValues()) {
            restTemplate.getForObject("http://localhost:8080/api/bill/BillStatusAccept/"+ strId, Void.class);
        }


        return "redirect:/payBillsResult";
    }

    @GetMapping("/payBillsResult")
    public String payBillsResult(@ModelAttribute("command") FormCommand command, Model model){
        return "redirect:/billsHistory";
    }
}
