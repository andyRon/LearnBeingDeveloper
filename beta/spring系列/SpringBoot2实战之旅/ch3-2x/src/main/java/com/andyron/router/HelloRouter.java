package com.andyron.router;

import com.andyron.handle.HelloHandle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author Andy Ron
 */
@Configuration
public class HelloRouter {

    @Bean
    public RouterFunction<ServerResponse> routerHello(HelloHandle helloHandle) {
        return RouterFunctions
                .route(RequestPredicates.GET("hello")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), helloHandle::hello);
    }
}
