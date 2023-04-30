package com.vietdev.springsecuritydemo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author VietDev
 * @date 01/05/2023
 * @role
 */
@Setter
@Getter
@RequiredArgsConstructor
public class AuthenticationRequest {
    private String email;
    private String password;
}

