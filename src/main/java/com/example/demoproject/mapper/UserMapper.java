package com.example.demoproject.mapper;

import com.example.demoproject.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    // 查看所有用户信息
    List<User> findAll();

    // 添加用户信息
    int insertUser(User user);

    // 根据用户名查询用户信息
    User getUserInfo(@Param("userName") String userName);

    // 验证用户信息
    User checkPassword(User user);
}
