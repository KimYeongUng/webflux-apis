package com.example.webfluxapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.webfluxapis"})
public class WebfluxApisApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxApisApplication.class, args);
    }

}
