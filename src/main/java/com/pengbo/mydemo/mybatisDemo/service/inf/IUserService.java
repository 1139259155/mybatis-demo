package com.pengbo.mydemo.mybatisDemo.service.inf;

import com.pengbo.mydemo.mybatisDemo.model.User;

public interface IUserService {
    void queryUserById(String id);

    void queryUserByName(String name);
}
