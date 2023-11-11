package com.example.webfluxapis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@lombok.Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("data")
public class Data {
    @Id
    @Column("id")
    private Long id;

    @Column("title")
    private String title;

    @Column("content")
    private String content;

    @Column("deleted")
    private String deleted;

    @CreatedDate
    private LocalDateTime firstInsertTime;

    @LastModifiedDate
    private LocalDateTime lastUpdatedTime;
}
