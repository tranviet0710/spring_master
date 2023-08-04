package com.eazybytes.repository;

import com.eazybytes.model.Holiday;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author VietDev
 * @date 04/08/2023
 * @role
 */
@Repository
@RequiredArgsConstructor
public class HolidayRepository {
    private final JdbcTemplate jdbcTemplate;
    private final String getAllHolidays = "SELECT * FROM HOLIDAYS";

    public List<Holiday> getAllHolidays() {
        var holidayRowMapper = BeanPropertyRowMapper.newInstance(Holiday.class);
        return jdbcTemplate.query(getAllHolidays, holidayRowMapper);
    }
}

