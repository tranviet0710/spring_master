package com.example.exercise2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.UUID;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.exercise2.controller", "com.example.exercise2.service", "com.example.exercise2.repository"})
public class AnkiApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnkiApplication.class);
    }
}

