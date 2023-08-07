package com.eazybytes.repository;

import com.eazybytes.model.Contact;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author VietDev
 * @date 03/08/2023
 * @role
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> getContactsByStatus(String status);

    @Modifying
    @Transactional
    @Query("UPDATE Contact c SET c.status = :status WHERE c.contactID = :id")
    void closeMessage(@PathParam("id") Integer id, @PathParam("status") String status);
}

