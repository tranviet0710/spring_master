package com.eazybytes.services;

import com.eazybytes.model.Holiday;
import com.eazybytes.repository.HolidayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author VietDev
 * @date 04/08/2023
 * @role
 */
@Service
@RequiredArgsConstructor
public class HolidayService {
    private final HolidayRepository holidayRepository;

    public List<Holiday> getAllHolidays() {
        return holidayRepository.getAllHolidays();
    }
}

