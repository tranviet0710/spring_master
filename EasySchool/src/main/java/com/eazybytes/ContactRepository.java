package com.eazybytes;

import com.eazybytes.model.Contact;
import com.eazybytes.rowmappers.ContactRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author VietDev
 * @date 03/08/2023
 * @role
 */
@Repository
public class ContactRepository {
    private final JdbcTemplate jdbcTemplate;
    private final String insertContact = "INSERT INTO " +
            "CONTACT_MSG (NAME,MOBILE_NUM,EMAIL,SUBJECT,MESSAGE,STATUS,CREATED_AT,CREATED_BY) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String getAllMessages = "SELECT * FROM CONTACT_MSG WHERE STATUS = ?";

    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveContactMessage(Contact contact) {
        return jdbcTemplate.update(insertContact,
                contact.getName(), contact.getMobileNum(), contact.getEmail(),
                contact.getSubject(), contact.getMessage(), contact.getStatus(),
                contact.getCreatedAt(), contact.getCreatedBy());
    }

    public List<Contact> getAllMessages(String status) {
        return jdbcTemplate.query(getAllMessages, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, status);
            }
        }, new ContactRowMapper());
    }
}

