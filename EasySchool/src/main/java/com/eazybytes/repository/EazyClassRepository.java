package com.eazybytes.repository;

import com.eazybytes.model.EazyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author VietDev
 * @date 11/08/2023
 * @role
 */
@Repository
public interface EazyClassRepository extends JpaRepository<EazyClass, Integer> {

    EazyClass findByName(String name);
}

