package com.eazybytes.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author VietDev
 * @date 03/08/2023
 * @role
 */
@Data
@MappedSuperclass
public class BaseEntity {
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDate updatedAt;
    private String updatedBy;
}

