package com.ylc.hhtally.service;

import com.ylc.hhtally.common.ResultJson;

public interface UserService {
    ResultJson login(String username, String password);
    ResultJson register(String username,String password);
}
