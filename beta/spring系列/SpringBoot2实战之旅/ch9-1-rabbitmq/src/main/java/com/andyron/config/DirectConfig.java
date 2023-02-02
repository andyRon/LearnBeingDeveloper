package com.andyron.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Andy Ron
 */
@Configuration
public class DirectConfig {
    public static final String DIRECT_QUEUE = "direct.queue";

    @Bean
    public Queue directQueue() {

        return new Queue("direct.queue", true);
    }
}
