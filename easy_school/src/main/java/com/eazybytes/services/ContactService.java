package com.eazybytes.services;

import com.eazybytes.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @author VietDev
 * @date 22/07/2023
 * @role
 */
@Service
@Slf4j
//@RequestScope
//@SessionScope
@ApplicationScope
public class ContactService {
    private int counter = 0;
//    private static final Logger log = LoggerFactory.getLogger(ContactService.class);
    public ContactService(){
        log.info("Contact service constructor called.");
    }
    public void sendMessageDetails(Contact contact){
        log.info(contact.toString());
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}

