package com.eazybytes.controllers;

import com.eazybytes.model.Person;
import com.eazybytes.model.Profile;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author VietDev
 * @date 11/08/2023
 * @role
 */
@Controller
public class ProfileController {

    @RequestMapping(value="/displayProfile", method = {RequestMethod.GET})
    public String displayProfilePage(Model model, HttpSession session){
        Person person = (Person) session.getAttribute("person");
        Profile profile = new Profile(person);
        model.addAttribute("profile", profile);
        return "profile.html";
    }
}

