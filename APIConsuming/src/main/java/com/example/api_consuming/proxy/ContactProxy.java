package com.example.api_consuming.proxy;

import com.example.api_consuming.configuration.ProjectConfiguration;
import com.example.api_consuming.model.Response;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "response", url = "http://localhost:8080/api/v1/", configuration = ProjectConfiguration.class)
public interface ContactProxy {
    @RequestMapping(method = {RequestMethod.GET}, value = "/responses")
    @Headers(value = "Content-type: application/json")
    List<Response> getAllResponse(@RequestParam("status") String status);
}
