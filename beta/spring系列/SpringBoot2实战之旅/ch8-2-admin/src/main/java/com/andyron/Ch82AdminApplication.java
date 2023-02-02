package com.andyron;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class Ch82AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch82AdminApplication.class, args);
    }

}
