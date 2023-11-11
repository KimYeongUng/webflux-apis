package com.example.webfluxapis.repo;

import com.example.webfluxapis.domain.Data;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DataRepository extends ReactiveCrudRepository<Data,Long> {

    @Modifying
    @Query("INSERT INTO DATA(TITLE,CONTENT) VALUES ( $1,$2 )")
    @Transactional
    Mono<Data> insert(String title,String content);

    @Query("select * from DATA")
    Flux<Data> selectAll();

    @Query("select * from DATA where id = $1")
    Flux<Data> getDataById(Long id);

    @Query("select * from DATA WHERE title LIKE $1")
    Flux<Data> getDataByTitle(String title);


}
