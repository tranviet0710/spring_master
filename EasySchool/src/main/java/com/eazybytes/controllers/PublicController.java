package com.eazybytes.controllers;

import com.eazybytes.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author VietDev
 * @date 07/08/2023
 * @role
 */
@Controller
@RequestMapping("/public")
public class PublicController {
    @GetMapping("/register")
    public String displayRegisterPage(Model model){
        model.addAttribute("person", new Person());
        return "register.html";
    }
}

