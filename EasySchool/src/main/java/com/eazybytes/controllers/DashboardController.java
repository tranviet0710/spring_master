package com.eazybytes.controllers;

import com.eazybytes.model.Person;
import com.eazybytes.model.Profile;
import com.eazybytes.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class DashboardController {
    private final PersonRepository personRepository;
    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET, RequestMethod.POST})
    public String displayDashboardPage(Authentication authentication, Model model, HttpSession session) throws Exception {
        Person person = personRepository.getByEmail(authentication.getName());
        model.addAttribute("username", person.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        session.setAttribute("authenticatedUser", person);
//        throw new Exception("It's been a bad day!");
        return "dashboard.html";
    }
}

