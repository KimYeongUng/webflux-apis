package com.example.webfluxapis.handler;

import com.example.webfluxapis.service.ApiService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
@Slf4j
public class APIHandler {

    private final ApiService apiService;

    public Mono<ServerResponse> getData(ServerRequest request){
        return ServerResponse.ok()
                .body(request.bodyToMono(JsonNode.class).flatMap(apiService::getData),JsonNode.class);
    }

}
