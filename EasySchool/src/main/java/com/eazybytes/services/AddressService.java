package com.eazybytes.services;

import com.eazybytes.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author VietDev
 * @date 09/08/2023
 * @role
 */
@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
}