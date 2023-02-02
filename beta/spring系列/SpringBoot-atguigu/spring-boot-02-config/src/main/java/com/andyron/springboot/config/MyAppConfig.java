package com.andyron.springboot.config;

import com.andyron.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 在配置文件中用<bean></bean>添加组件
 */
@Configuration
public class MyAppConfig {

    // 将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名
    @Bean
    public HelloService helloService01() {
        System.out.println("配置类@Bean给容器中添加组件了");
        return new HelloService();
    }

}
