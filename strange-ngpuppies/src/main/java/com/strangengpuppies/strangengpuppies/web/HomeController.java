package com.strangengpuppies.strangengpuppies.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  
  
  @GetMapping ("/")
  public String indexHandler(){
    
    return "index";
  }
}