package com.andyron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Ch51Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch51Application.class, args);
    }

}
