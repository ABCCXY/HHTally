package com.ylc.hhtally.service.impl;

import com.ylc.hhtally.mapper.UserMapper;
import com.ylc.hhtally.pojo.User;
import com.ylc.hhtally.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public String login(String username, String password) {
        String msg=null;
        User user = userMapper.login(username);
        if (null==user)msg="用户名错误";
        else  {
            if (user.getPassword().equals(password))msg="登陆成功";
            else msg="密码错误";
        }
        return msg;
    }

    @Override
    public String register(String username,String password) {
        String msg=null;
        int i = userMapper.register(username, password);
        if (i==1)msg="注册成功";
        else msg="注册失败";
        return msg;
    }
}
