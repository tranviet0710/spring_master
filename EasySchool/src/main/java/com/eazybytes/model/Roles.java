package com.eazybytes.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author VietDev
 * @date 09/08/2023
 * @role
 */
@Entity
@Data
public class Roles extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer roleId;

    private String roleName;
}

