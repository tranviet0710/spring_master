package com.eazybytes.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author VietDev
 * @date 26/07/2023
 * @role
 */
@Data
@AllArgsConstructor
public class Holiday {
    private String day;
    private String reason;
    private Type type;

    public enum Type{
        FESTIVAL, FEDERAL
    }
}

