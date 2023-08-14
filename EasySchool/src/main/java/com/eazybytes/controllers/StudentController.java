package com.eazybytes.controllers;

import com.eazybytes.model.Person;
import com.eazybytes.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author VietDev
 * @date 13/08/2023
 * @role
 */
@Controller
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {
    private final PersonService personService;

    @RequestMapping(value = "/displayCourses", method = {RequestMethod.GET})
    public String displayCourses(Model model, Authentication authentication) {
        Person foundPerson = personService.findByEmail(authentication.getName());
        model.addAttribute("person", foundPerson);
        return "courses_enrolled.html";
    }
}

