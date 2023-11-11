package com.example.webfluxapis.service;

import com.example.webfluxapis.repo.DataRepository;
import com.example.webfluxapis.util.CommonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class R2dbcService {

    private final DataRepository repository;
    public Mono<JsonNode> getDataById(JsonNode jsonNode){
        Map requestMap = CommonUtils.getMapFromRequest(jsonNode);
        Long id = (Long) requestMap.get("id");
        repository.getDataById(id);
        return Mono.empty();
    }
}
