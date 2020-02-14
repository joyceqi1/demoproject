package com.example.demoproject.service;

import com.example.demoproject.entity.ResponseBean;
import com.example.demoproject.entity.User;
import com.example.demoproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    /**
     * 查看所有用户信息
     * @return
     */
    public ResponseBean<List<User>> findAll(){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode("200");
        responseBean.setMessage("query success");
        List<User> userList = userMapper.findAll();
        responseBean.setResult(userList);
        return responseBean;
    };

    /**
     * 注册时添加用户信息
     * @param user
     * @return
     */
    public ResponseBean<String> insertUser(User user){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode("200");
        responseBean.setMessage("query success");
        String status = "";
        try{
            userMapper.insertUser(user);
            status = "success";
        }catch (Exception e){
            System.out.println(e);
            status = "false";
        }
        responseBean.setResult(status);
        return responseBean;
    }

    /**
     * 根据用户名查询用户信息
     */
    public ResponseBean<User> getUserInfo(String userName){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode("200");
        responseBean.setMessage("query success");
        User user = new User();
        try{
            user = userMapper.getUserInfo(userName);
        }catch (Exception e){
             System.out.println(e);
        }
        responseBean.setResult(user);
        return responseBean;
    }

    /**
     * 验证用户信息
     * @param user
     * @return
     */
    public ResponseBean<String> checkPassword(User user) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode("200");
        responseBean.setMessage("query success");
        String status = "";
        try{
            User resultUser = userMapper.checkPassword(user);
            if(resultUser != null){
                status = "success";
            } else {
                status = "登录信息不存在！";
            }
        }catch (Exception e){
            System.out.println(e);
            status = "false";
        }
        responseBean.setResult(status);
        return responseBean;
    }
}
