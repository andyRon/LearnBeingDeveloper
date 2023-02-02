package com.andyron.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




/*

 */
@MapperScan("com.andyron.springboot.mapper")
@SpringBootApplication
public class SpringBoot09CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot09CacheApplication.class, args);
    }

}
