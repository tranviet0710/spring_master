package com.eazybytes.rowmappers;

import com.eazybytes.model.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author VietDev
 * @date 03/08/2023
 * @role
 */
public class ContactRowMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setContactID(rs.getInt("CONTACT_ID"));
        contact.setName(rs.getString("NAME"));
        contact.setMobileNum(rs.getString("MOBILE_NUM"));
        contact.setEmail(rs.getString("EMAIL"));
        contact.setSubject(rs.getString("SUBJECT"));
        contact.setMessage(rs.getString("MESSAGE"));
        contact.setMessage(rs.getString("STATUS"));
        if (rs.getTimestamp("CREATED_AT") != null) {
            contact.setCreatedAt(rs.getTimestamp("CREATED_AT").toLocalDateTime());
        }
        if (rs.getTimestamp("UPDATED_AT") != null) {
            contact.setCreatedAt(rs.getTimestamp("UPDATED_AT").toLocalDateTime());
        }
        contact.setCreatedBy(rs.getString("CREATED_BY"));
        contact.setUpdatedBy(rs.getString("UPDATED_BY"));
        return contact;
    }
}

