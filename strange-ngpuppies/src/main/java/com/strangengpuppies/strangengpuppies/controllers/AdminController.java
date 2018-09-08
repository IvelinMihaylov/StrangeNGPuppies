package com.strangengpuppies.strangengpuppies.controllers;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.model.Service;
import com.strangengpuppies.strangengpuppies.model.Subscriber;
import com.strangengpuppies.strangengpuppies.model.User;
import com.strangengpuppies.strangengpuppies.model.formControl.FormCommand;
import com.strangengpuppies.strangengpuppies.service.base.BillService;
import com.strangengpuppies.strangengpuppies.service.base.SubscriberService;
import com.strangengpuppies.strangengpuppies.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;

@Controller
public class AdminController {

    private final SubscriberService subscriberService;
    private final UserService userService;
    private final BillService billService;

    @Autowired
    public AdminController(SubscriberService subscriberService, UserService userService, BillService billService) {
        this.subscriberService = subscriberService;
        this.userService = userService;
        this.billService = billService;
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
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange("http://localhost:8080/api/user/listAllBanks", HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {} );
        mav.addObject("banks", responseEntity.getBody());
        return mav;
    }

    @GetMapping("/createBill")
    public ModelAndView showCreateBillForm() {
        ModelAndView mav = new ModelAndView("adminCreateBill");
        mav.addObject("command", new FormCommand());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Service>> responseEntity = restTemplate.exchange("http://localhost:8080/api/service/allservices",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Service>>() {});
        mav.addObject("services", responseEntity.getBody());
        HashSet<String> listOfCurrencies= new HashSet<>();
        listOfCurrencies.add("USD");
        listOfCurrencies.add("EUR");
        listOfCurrencies.add("GBP");
        listOfCurrencies.add("RUB");
        listOfCurrencies.add("BGN");

        mav.addObject("currencies", listOfCurrencies);

        return mav;
    }
}
