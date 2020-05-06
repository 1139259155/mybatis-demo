package com.pengbo.mydemo.mybatisDemo.mapper;

import com.pengbo.mydemo.mybatisDemo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    void queryUserById(String id);

    @Select("select * from user")
    void queryUserByName(String name);
}
