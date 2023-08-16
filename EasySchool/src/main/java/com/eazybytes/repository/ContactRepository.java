package com.eazybytes.repository;

import com.eazybytes.model.Contact;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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

    //    JPQL
    @Query("SELECT c FROM Contact c WHERE c.status=:status ")
//    Native query
//    @Query(value = "SELECT * FROM contact_msg c WHERE c.status= ?1", nativeQuery = true)
    Page<Contact> getContactsByStatusWithQuery(String status, Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE Contact c SET c.status = :status WHERE c.contactID = :id")
    int closeMessage(@PathParam("id") Integer id, @PathParam("status") String status);

    /**
     * NAMED QUERY
     **/
    Page<Contact> findOpenMsgs(String status, Pageable pageable);

    @Modifying
    @Transactional
    int updateMsgStatus(@PathParam("id") Integer id, @PathParam("status") String status);

    /**
     * NAMED NATIVE QUERY
     */
    Page<Contact> findOpenMsgsNative(String status, Pageable pageable);

    @Modifying
    @Transactional
    int updateMsgStatusNative(@PathParam("id") Integer id, @PathParam("status") String status);
}

