package com.eazybytes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author VietDev
 * @date 14/07/2023
 * @role
 */
@Controller
public class HomeController {
    @RequestMapping(value = {"", "/", "home"})
    public String displayHomepage() {
        return "home.html";
    }

}

