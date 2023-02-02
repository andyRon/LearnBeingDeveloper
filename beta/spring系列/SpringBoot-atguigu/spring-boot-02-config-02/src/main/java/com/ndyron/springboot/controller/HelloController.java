package com.ndyron.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andy Ron
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello!!!!!";
    }
}
