package com.example.api_consuming.configuration;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author VietDev
 * @date 16/08/2023
 * @role
 */
@Configuration
public class ProjectConfiguration {
    private static final String username = "admin@gmail.com";
    private static final String password = "password123";
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor(username, password);
    }

    @Bean
    public RestTemplate restTemplate(){
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        return restTemplateBuilder.basicAuthentication(username, password).build();
    }

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .filter(ExchangeFilterFunctions.basicAuthentication(username, password))
                .build();
    }
}

