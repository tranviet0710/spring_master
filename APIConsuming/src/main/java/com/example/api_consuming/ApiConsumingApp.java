package com.example.api_consuming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.api_consuming.proxy")
public class ApiConsumingApp {

    public static void main(String[] args) {
        SpringApplication.run(ApiConsumingApp.class, args);
    }

}
