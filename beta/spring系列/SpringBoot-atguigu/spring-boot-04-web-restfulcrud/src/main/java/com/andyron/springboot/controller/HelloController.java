package com.andyron.springboot.controller;

import com.andyron.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Andy Ron
 */
@Controller
public class HelloController {

    @ResponseBody
    @GetMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if (user.equals("aaa")) {  // 测试异常
            throw new UserNotExistException();
        }
        return "Hello!!!!!!";

    }

    // 查出一些数据，在页面展示
    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("andy", "jack", "tony"));
        return "success";
    }


}
