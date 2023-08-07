package com.eazybytes.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author VietDev
 * @date 26/07/2023
 * @role
 */
@Data
@Entity
@Table(name = "holidays")
public class Holiday extends BaseEntity {
    @Id
    private String day;
    private String reason;
    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        FESTIVAL, FEDERAL
    }
}

