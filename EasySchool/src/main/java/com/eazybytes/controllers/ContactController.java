package com.eazybytes.controllers;

import com.eazybytes.constants.EazySchoolConstants;
import com.eazybytes.model.Contact;
import com.eazybytes.services.ContactService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author VietDev
 * @date 21/07/2023
 * @role
 */
@Controller
public class ContactController {
    private final ContactService contactService;
    private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }


    @RequestMapping("/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

//    @RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
//    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
//                                    @RequestParam String email, @RequestParam String subject,
//                                    @RequestParam String message){
//        log.info("Name: " + name);
//        log.info("MobileNum: " + mobileNum);
//        log.info("Email: " + email);
//        log.info("Subject: " + subject);
//        log.info("Message: " + message);
//        return new ModelAndView("redirect:/contact");
//    }

    @RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
    public String saveMessage(@Valid @ModelAttribute(name = "contact") Contact contact, Errors errors) {
        if (errors.hasErrors()) {
            log.error("Contact form validation failed due to: " + errors);
//          render template and send it as a response without removing old model attribute
            return "contact.html";
        }
        contactService.saveContactMessage(contact);
        return "redirect:/contact";
    }

    @RequestMapping(value = "/displayMessages/{page}", method = RequestMethod.GET)
    public ModelAndView displayMessages(@PathVariable Integer page,
                                        @RequestParam String sortField,
                                        @RequestParam String sortDir) {
//        List<Contact> contacts = contactService.getAllContactMessages(EazySchoolConstants.OPEN);
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize, sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
        Page<Contact> contactPage = contactService.getAllContactMessages(EazySchoolConstants.OPEN, pageable);
        List<Contact> contacts = contactPage.getContent();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("contactMsgs", contacts);
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("sortField", sortField);
        modelAndView.addObject("sortDir", sortDir);
        modelAndView.addObject("totalPages", contactPage.getTotalPages());
        modelAndView.addObject("reversedSortDir", sortDir.equals("asc") ? "desc" : "asc");
        modelAndView.setViewName("messages.html");
        return modelAndView;
    }

    @RequestMapping(value = "/closeMsg", method = RequestMethod.GET)
    public String closeMessage(@RequestParam int id) {
        contactService.closeMessage(id);
        return "redirect:/displayMessages";
    }
}

