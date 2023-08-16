package com.eazybytes.controllers;

import com.eazybytes.model.Address;
import com.eazybytes.model.Person;
import com.eazybytes.model.Profile;
import com.eazybytes.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author VietDev
 * @date 11/08/2023
 * @role
 */
@Controller("profileControllerBean")
@RequiredArgsConstructor
public class ProfileController {
    private final PersonRepository personRepository;

    @RequestMapping(value = "/displayProfile", method = {RequestMethod.GET})
    public String displayProfilePage(Model model, HttpSession session) {
        Person person = (Person) session.getAttribute("authenticatedUser");
        Profile profile = new Profile();
        profile.setName(person.getName());
        profile.setEmail(person.getEmail());
        profile.setMobileNumber(person.getMobileNumber());
        if (person.getAddress() != null && person.getAddress().getAddressId() > 0) {
            profile.setAddress1(person.getAddress().getAddress1());
            profile.setAddress2(person.getAddress().getAddress2());
            profile.setCity(person.getAddress().getCity());
            profile.setState(person.getAddress().getState());
            profile.setZipCode(person.getAddress().getZipCode());
        }
        model.addAttribute("profile", profile);
        return "profile.html";
    }

    @RequestMapping(value = "/updateProfile", method = {RequestMethod.POST})
    public String updateProfile(@Valid @ModelAttribute("profile") Profile profile, Errors errors, HttpSession session) {
        if (errors.hasErrors()) {
            return "profile.html";
        }
        Person person = (Person) session.getAttribute("authenticatedUser");
        if (profile != null) {
            person.setName(profile.getName());
            person.setEmail(profile.getEmail());
            person.setMobileNumber(profile.getMobileNumber());
            if (person.getAddress() == null) {
                person.setAddress(new Address());
            }
            person.getAddress().setAddress1(profile.getAddress1());
            person.getAddress().setAddress2(profile.getAddress2());
            person.getAddress().setCity(profile.getCity());
            person.getAddress().setState(profile.getState());
            person.getAddress().setZipCode(profile.getZipCode());
        }
        Person savedPerson = personRepository.save(person);
        session.setAttribute("authenticatedUser", savedPerson);
        return "redirect:/displayProfile";
    }
}

