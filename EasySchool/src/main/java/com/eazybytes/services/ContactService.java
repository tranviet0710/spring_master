package com.eazybytes.services;

import com.eazybytes.ContactRepository;
import com.eazybytes.constants.EazySchoolConstants;
import com.eazybytes.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.time.LocalDateTime;
import java.util.List;

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
    @Autowired
    private ContactRepository contactRepository;

    //    private static final Logger log = LoggerFactory.getLogger(ContactService.class);
    public boolean saveContactMessage(Contact contact) {
        boolean isSaved = false;
        contact.setCreatedAt(LocalDateTime.now());
        contact.setCreatedBy(EazySchoolConstants.ANONYMOUS);
        contact.setStatus(EazySchoolConstants.OPEN);
        int result = contactRepository.saveContactMessage(contact);
        if (result > 0) {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> getAllContactMessages(String status) {
        return contactRepository.getAllMessages(status);
    }
}

