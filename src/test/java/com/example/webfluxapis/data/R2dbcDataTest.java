package com.example.webfluxapis.data;

import com.example.webfluxapis.domain.Data;
import com.example.webfluxapis.repo.DataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import reactor.test.StepVerifier;

@DataR2dbcTest
public class R2dbcDataTest {

    @Autowired
    DataRepository repository;
    Data data;
    @BeforeEach
    public void setUp(){
        repository.deleteAll();
        data = Data.builder()
                .title("test title")
                .content("test content")
                .build();
    }

    @Test
    public void insertTest(){
        repository.insert(data.getTitle(),data.getContent())
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();
    }
}
