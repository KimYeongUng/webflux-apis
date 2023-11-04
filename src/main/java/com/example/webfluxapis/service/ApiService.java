package com.example.webfluxapis.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import static com.example.webfluxapis.util.CommonUtils.getMapFromRequest;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiService {
    private final WebClient webClient;
    private final static String TIME_URL = "worldtimeapi.org";
    public Mono<JsonNode> getData(JsonNode request){
        getMapFromRequest(request);
        return getWorldTime();
    }

    private Mono<JsonNode> getWorldTime(){

        return webClient.get().uri(uriBuilder ->
                uriBuilder
                        .scheme("http")
                        .host(TIME_URL)
                        .path("/api/Asia/seoul")
                        .build())
                .retrieve()
                .bodyToMono(JsonNode.class);
    }
}
