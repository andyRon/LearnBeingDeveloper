package com.andyron.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/index")
    public Object index() {
        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println(user.toString());
        }
        return userList;
    }


}
