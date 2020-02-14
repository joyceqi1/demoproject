package com.example.demoproject.controller;

import com.example.demoproject.entity.ResponseBean;
import com.example.demoproject.entity.User;
import com.example.demoproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods =
        {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.HEAD,
                RequestMethod.OPTIONS, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH})
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     * 查看用户列表
     * @return
     */
    @RequestMapping("/list")
    public ResponseBean findAll(){
        return userService.findAll();
    }

    /**
     * 插入单条用户信息
     * @param user
     * @return
     */
    @PostMapping("/insert")
    public ResponseBean insertUser(@RequestBody User user){
        System.out.println("#########" + user + "##########");
        return userService.insertUser(user);
    }

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    @GetMapping("/getUserInfo")
    public ResponseBean getUserInfo(@RequestParam("userName") String userName){
        return userService.getUserInfo(userName);
    }

    /**
     * 验证用户信息
     * @param user
     * @return
     */
    @PostMapping("/checkPassword")
    public ResponseBean checkPassword(@RequestBody User user) {
        return userService.checkPassword(user);
    }
}
