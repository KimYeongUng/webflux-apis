package com.example.webfluxapis.route;


import com.example.webfluxapis.handler.APIHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class ApiRouter {
    @Bean
    public RouterFunction<ServerResponse> route(APIHandler handler){
        return RouterFunctions.route()
                .GET("/api/getData",handler::getData)
                .build();
    }
}
