package com.andyron.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Andy Ron
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource") // 把配置文件中的属性绑定进来
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }
}
