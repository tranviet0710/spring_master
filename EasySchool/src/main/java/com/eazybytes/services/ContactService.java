package com.eazybytes.services;

import com.eazybytes.constants.EazySchoolConstants;
import com.eazybytes.model.Contact;
import com.eazybytes.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

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
//        contact.setCreatedAt(LocalDateTime.now());
//        contact.setCreatedBy(EazySchoolConstants.ANONYMOUS);
        contact.setStatus(EazySchoolConstants.OPEN);
        try {
            contactRepository.save(contact);
            isSaved = true;
        } catch (Exception ex) {
        }
        return isSaved;
    }

    public List<Contact> getAllContactMessages(String status) {
        return contactRepository.getContactsByStatus(status);
    }

    public boolean closeMessage(int id) {
//        Contact contact = contactRepository.findById(id).orElse(null);
//        if (contact != null) {
//            contact.setStatus(EazySchoolConstants.CLOSE);
//            contactRepository.save(contact);
//        }
        boolean isClosed = false;
        int rows = contactRepository.updateMsgStatus(id, EazySchoolConstants.CLOSE);
        if (rows > 0) {
            isClosed = true;
        }
        return isClosed;
    }

    public Page<Contact> getAllContactMessages(String status, Pageable pageable) {
        return contactRepository.findOpenMsgs(status, pageable);
    }
}

