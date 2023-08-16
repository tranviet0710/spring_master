package com.example.api_consuming.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author VietDev
 * @date 15/08/2023
 * @role
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String responseStatus;
    private String responseMessage;
}

