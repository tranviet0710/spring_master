package com.eazybytes.controllers;

import com.eazybytes.model.Contact;
import com.eazybytes.services.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    public String displayContactPage(){
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
    public ModelAndView saveMessage(Contact contact){
        contactService.sendMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }
}

