package com.ylc.hhtally.controller;

import com.ylc.hhtally.pojo.User;
import com.ylc.hhtally.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(String username,String password){
        String msg = userService.login(username, password);
        return msg;
    }

    @PostMapping("/register")
    public String register(String username,String password){
        String msg=userService.register(username, password);
        return msg;
    }
}
