package com.example.api_consuming.controller;

import com.example.api_consuming.model.Response;
import com.example.api_consuming.proxy.ContactProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.print.attribute.standard.Media;
import java.util.Arrays;
import java.util.List;

/**
 * @author VietDev
 * @date 16/08/2023
 * @role
 */
@RestController
public class ResponseController {
    @Autowired
    ContactProxy contactProxy;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient webClient;
    @GetMapping("/feign_client/responses")
    public List<Response> getFeignClientResponses(@RequestParam("status") String status){
        return contactProxy.getAllResponse(status);
    }

    @GetMapping("/rest_template/responses")
    public ResponseEntity<Response[]> getRestTemplateResponses(@RequestParam("status") String status){
        String uri = "http://localhost:8080/api/v1/responses";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<Response[]> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, Response[].class);
        return responseEntity;
    }

    @GetMapping("/web_client/responses")
    public Flux<Response> getWebClientResponses(@RequestParam("status") String status){
        String uri = "http://localhost:8080/api/v1/responses";
        return webClient.get().uri(uri).retrieve().bodyToFlux(Response.class);
    }
}

