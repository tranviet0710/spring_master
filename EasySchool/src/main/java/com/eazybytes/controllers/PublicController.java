package com.eazybytes.controllers;

import com.eazybytes.model.Person;
import com.eazybytes.services.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author VietDev
 * @date 07/08/2023
 * @role
 */
@Controller
@RequestMapping("/public")
@RequiredArgsConstructor
public class PublicController {
    private final PersonService personService;
    @GetMapping("/register")
    public String displayRegisterPage(Model model){
        model.addAttribute("person", new Person());
        return "register.html";
    }

    @PostMapping("/createUser")
    public String createUser(@Valid @ModelAttribute("person") Person person, Errors errors){
        if(errors.hasErrors()){
            return "register.html";
        }
        Person createdPerson = personService.createUser(person);
        if(createdPerson!=null){
            return "redirect:/login?register=true";
        }else {
            return "register.html";
        }
    }
}

