package com.eazybytes.model;

import lombok.Data;

/**
 * @author VietDev
 * @date 22/07/2023
 * @role
 */
@Data
public class Contact {
    private String name;
    private String mobileNum;
    private String email;
    private String subject;
    private String message;
}

