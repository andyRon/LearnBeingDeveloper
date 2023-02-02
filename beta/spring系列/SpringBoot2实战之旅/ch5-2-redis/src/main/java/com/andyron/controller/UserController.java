package com.andyron.controller;

import com.andyron.entity.User;
import com.andyron.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andy Ron
 */
@RestController
public class UserController {

    @Autowired
    private RedisService redisService;

    @GetMapping(value = "saveUser")
    public String saveUser(Long id, String userName, String userPassword) {
        User user = new User(id, userName, userPassword);
        redisService.set(id.toString(), userPassword);
        return "success";
    }

    @GetMapping(value = "getUserById")
    public Object getUserById(Long id) {
        return redisService.get(id.toString());
    }

}
