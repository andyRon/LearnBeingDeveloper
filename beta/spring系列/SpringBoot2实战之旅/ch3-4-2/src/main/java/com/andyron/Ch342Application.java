package com.andyron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Ch342Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch342Application.class, args);
    }

    @GetMapping("hello")
    public String hello() {
        return "哈哈";
    }
}

