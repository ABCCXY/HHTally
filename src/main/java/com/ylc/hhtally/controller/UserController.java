package com.ylc.hhtally.controller;

import com.ylc.hhtally.common.ResultJson;
import com.ylc.hhtally.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResultJson login(String username, String password){
        return userService.login(username, password);
    }

    @PostMapping("/register")
    public String register(String username,String password){
        String msg=userService.register(username, password);
        return msg;
    }
}
