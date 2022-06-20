package com.example.sample;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
  private static final Logger log = LoggerFactory.getLogger(UserController.class);
  
  @Autowired
  @Qualifier("com.example.sample.UserServiceImpl")
  private UserService service;
  
  @GetMapping("/login")
  @ResponseBody
  public UserDTO loginCheck(@RequestParam("id") String id , @RequestParam("passwd") String passwd) {
    
    Map map = new HashMap();
    map.put("id", id);
    map.put("passwd", passwd);
    
    UserDTO dto = service.userLogin(map);

    return dto;

  }
  
  @GetMapping("/")
  public String home() {
    
    return "test1";
  }
}
