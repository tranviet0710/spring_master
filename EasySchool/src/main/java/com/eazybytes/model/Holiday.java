package com.eazybytes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author VietDev
 * @date 26/07/2023
 * @role
 */
@Data
public class Holiday extends BaseEntity{
    private String day;
    private String reason;
    private Type type;

    public enum Type {
        FESTIVAL, FEDERAL
    }
}

