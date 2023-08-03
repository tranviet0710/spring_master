package com.eazybytes;

import com.eazybytes.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author VietDev
 * @date 03/08/2023
 * @role
 */
@Repository
public class ContactRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String insertContact = "INSERT INTO " +
            "CONTACT_MSG (NAME,MOBILE_NUM,EMAIL,SUBJECT,MESSAGE,STATUS,CREATED_AT,CREATED_BY) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public int saveContactMessage(Contact contact) {
        return jdbcTemplate.update(insertContact,
                contact.getName(), contact.getMobileNum(), contact.getEmail(),
                contact.getSubject(), contact.getMessage(), contact.getStatus(),
                contact.getCreatedAt(), contact.getCreatedBy());
    }
}

