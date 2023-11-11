package com.example.webfluxapis.route;

import com.example.webfluxapis.handler.R2dbcHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class R2dbcRouter {

    @Bean
    public RouterFunction<ServerResponse> r2dbcRoute(R2dbcHandler handler){
        return RouterFunctions.route()
                .POST("/r2dbc/get-data-by-id",handler::getDataById)
                .build();
    }
}
