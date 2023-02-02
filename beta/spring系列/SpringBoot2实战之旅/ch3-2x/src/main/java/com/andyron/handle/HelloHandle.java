package com.andyron.handle;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author Andy Ron
 */
@Component
@RestController
public class HelloHandle {

    @GetMapping("hi")
    public String hi() {
        return "hi,ddd";
    }

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject("Hello, 123"));
    }


}
