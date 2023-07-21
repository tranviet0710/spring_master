package com.eazybytes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author VietDev
 * @date 21/07/2023
 * @role
 */
@Controller
public class ContactController {
    @RequestMapping("/contact")
    public String displayContactPage(){
        return "contact";
    }
}

