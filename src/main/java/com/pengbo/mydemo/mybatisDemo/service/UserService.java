package com.pengbo.mydemo.mybatisDemo.service;

import com.pengbo.mydemo.mybatisDemo.mapper.UserMapper;
import com.pengbo.mydemo.mybatisDemo.model.User;
import com.pengbo.mydemo.mybatisDemo.service.inf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService implements IUserService {

    @Autowired
    UserMapper userMapper;

    public void queryUserById(String id) {
        userMapper.queryUserById(id);
    }

    public void queryUserByName(String name) {
        userMapper.queryUserByName(name);
    }
}
