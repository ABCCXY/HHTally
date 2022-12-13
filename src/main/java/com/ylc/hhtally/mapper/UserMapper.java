package com.ylc.hhtally.mapper;

import com.ylc.hhtally.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User login(String username);
    int register(@Param("username") String username,@Param("password") String password);
}
