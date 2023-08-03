package com.eazybytes.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author VietDev
 * @date 02/08/2023
 * @role
 */
@Controller
public class DashboardController {
    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET})
    public String displayDashboardPage(Authentication authentication, Model model) throws Exception {
        model.addAttribute("username", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        throw new Exception("It's been a bad day!");
//        return "dashboard.html";
    }
}

