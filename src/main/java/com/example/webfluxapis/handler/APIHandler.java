package com.example.webfluxapis.handler;

import com.example.webfluxapis.service.ApiService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class APIHandler {

    private final ApiService apiService;

    public Mono<ServerResponse> getData(ServerRequest request){
        return ServerResponse.ok()
                .body(request.bodyToMono(JsonNode.class).flatMap(apiService::getData),JsonNode.class);
    }
}
