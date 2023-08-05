package com.eazybytes.repository;

import com.eazybytes.model.Contact;
import com.eazybytes.rowmappers.ContactRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
            "contact_msg (NAME,MOBILE_NUM,EMAIL,SUBJECT,MESSAGE,STATUS,CREATED_AT,CREATED_BY) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String getAllMessages = "SELECT * FROM contact_msg WHERE STATUS = ?";
    private final String closeMessage = "UPDATE contact_msg SET STATUS=?, UPDATED_BY=?, UPDATED_AT=? WHERE CONTACT_ID=?";

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

    public boolean closeMessage(int id, String close, String name) {
        boolean isUpdated = false;
        int result = jdbcTemplate.update(closeMessage, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, close);
                ps.setString(2, name);
                ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                ps.setInt(4, id);
            }
        });

        if (result > 0) {
            isUpdated = true;
        }
        return isUpdated;
    }
}

