package com.ylc.hhtally.service.impl;

import com.ylc.hhtally.common.ResultCode;
import com.ylc.hhtally.common.ResultJson;
import com.ylc.hhtally.mapper.UserMapper;
import com.ylc.hhtally.pojo.User;
import com.ylc.hhtally.service.UserService;
import com.ylc.hhtally.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultJson login(String username, String password) {
        User user = userMapper.login(username);
        if (null==user){
            return ResultJson.failed(ResultCode.USER_NOT_EXIST);
        }
        else  {
            if (user.getPassword().equals(password)){
                return ResultJson.success(ResultCode.SUCCESS.code(), "登录成功", JwtUtil.sign( String.valueOf(user.getUserId()),null));
            }
            else return ResultJson.failed(ResultCode.USER_LOGIN_ERROR);
        }
    }

    @Override
    public ResultJson register(String username,String password) {
        if (userMapper.login(username)!=null){
            return ResultJson.failed(ResultCode.ERROR.code(),"用户名已存在");
        }
        int i = userMapper.register(username, password);
        if (i==1){
            return ResultJson.success(ResultCode.SUCCESS.code(),"注册成功");
        }
        else return ResultJson.failed(ResultCode.ERROR.code(),"注册失败");
    }
}
