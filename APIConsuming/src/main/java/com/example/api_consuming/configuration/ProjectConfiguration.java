package com.example.api_consuming.configuration;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * @author VietDev
 * @date 16/08/2023
 * @role
 */
public class ProjectConfiguration {
    private static final String username = "admin@gmail.com";
    private static final String password = "password123";
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor(username, password);
    }
}

