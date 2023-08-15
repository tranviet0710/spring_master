package com.eazybytes.rest;

import com.eazybytes.model.Contact;
import com.eazybytes.model.Response;
import com.eazybytes.services.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author VietDev
 * @date 15/08/2023
 * @role
 */
@RestController
@RequestMapping(value = "/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class ContactRestController {
    private ContactService contactService;
    @GetMapping("/responses")
    public ResponseEntity<Object> getAllResponse(){
        List<Response> responses = Arrays.asList(
          new Response("400", "BAD REQUEST"),
                new Response("201", "CREATED"),
                new Response("200", "OK"),
                new Response("500", "SERVER ERROR")
        );
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }
}

