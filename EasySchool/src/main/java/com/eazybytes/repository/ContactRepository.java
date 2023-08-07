package com.eazybytes.repository;

import com.eazybytes.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author VietDev
 * @date 03/08/2023
 * @role
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> getContactsByStatus(String status);

//    @Modifying
//    @Query("Update contact_msg set status=?2, updated_by=?3 where contactID=?1")
//    void closeMessage(Integer id, String status, String name);
}

