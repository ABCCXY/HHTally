package com.ylc.hhtally.service;

import com.ylc.hhtally.pojo.User;

public interface UserService {
    String login(String username,String password);
    String register(String username,String password);
}
