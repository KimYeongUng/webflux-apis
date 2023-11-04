package com.example.webfluxapis.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class CommonUtils {

    public static Map<?,?> getMapFromRequest(JsonNode request) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(request,Map.class);
    }
}
