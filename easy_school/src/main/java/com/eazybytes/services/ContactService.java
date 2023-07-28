package com.eazybytes.services;

import com.eazybytes.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author VietDev
 * @date 22/07/2023
 * @role
 */
@Service
@Slf4j
@RequestScope
public class ContactService {
    public int counter = 0;
//    private static final Logger log = LoggerFactory.getLogger(ContactService.class);
    public ContactService(){
        log.info("Contact service constructor called.");
    }
    public void sendMessageDetails(Contact contact){
        log.info(contact.toString());
    }
}

