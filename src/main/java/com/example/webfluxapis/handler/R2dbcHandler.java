package com.example.webfluxapis.handler;

import com.example.webfluxapis.service.R2dbcService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class R2dbcHandler {
    private final R2dbcService r2dbcService;

    public Mono<ServerResponse> getDataById(ServerRequest request){
        return ServerResponse.ok().body(request.bodyToMono(JsonNode.class)
                .flatMap(r2dbcService::getDataById),JsonNode.class);
    }
}
