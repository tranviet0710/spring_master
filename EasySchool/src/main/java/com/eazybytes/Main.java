package com.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.eazybytes.repository")
@EntityScan("com.eazybytes.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}