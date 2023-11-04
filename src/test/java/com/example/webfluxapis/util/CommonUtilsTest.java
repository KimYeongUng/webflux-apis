package com.example.webfluxapis.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CommonUtilsTest {
    JsonNode jsonNode;
    @BeforeEach
    void setUp() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode nodes = mapper.createObjectNode();
        nodes.put("region","Asia/Seoul");
        jsonNode = nodes;
    }
    @Test
    void getMapFromRequest() {
        System.out.println(jsonNode.toPrettyString());
        Map<?,?> map = CommonUtils.getMapFromRequest(jsonNode);
        assertEquals(map.get("region"),"Asia/Seoul");
    }
}