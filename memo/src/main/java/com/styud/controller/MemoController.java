package com.styud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.styud.model.MemoDAO;

@Controller
public class MemoController {

  @Autowired
  private MemoDAO dao;
  
  @GetMapping("/")
  public String home() {
    
    return "/home";
  }
}
