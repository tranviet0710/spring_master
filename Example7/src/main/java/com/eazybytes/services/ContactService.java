package com.eazybytes.services;

import com.eazybytes.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author VietDev
 * @date 22/07/2023
 * @role
 */
@Service
public class ContactService {
    private static final Logger log = LoggerFactory.getLogger(ContactService.class);
    public void sendMessageDetails(Contact contact){
        log.info(contact.toString());
    }
}

