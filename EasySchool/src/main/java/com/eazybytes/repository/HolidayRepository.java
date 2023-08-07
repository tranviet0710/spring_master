package com.eazybytes.repository;

import com.eazybytes.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author VietDev
 * @date 04/08/2023
 * @role
 */
@Repository
public interface HolidayRepository extends JpaRepository<Holiday, String> {
}
