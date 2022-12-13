package com.ylc.hhtally.mapper;

import com.ylc.hhtally.pojo.User;

public interface UserMapper {
    User login(String username);
    int register(User user);
}
