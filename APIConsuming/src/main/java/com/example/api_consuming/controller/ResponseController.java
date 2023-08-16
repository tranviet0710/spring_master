package com.example.api_consuming.controller;

import com.example.api_consuming.model.Response;
import com.example.api_consuming.proxy.ContactProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/responses")
    public List<Response> getResponses(@RequestParam("status") String status){
        return contactProxy.getAllResponse(status);
    }
}

