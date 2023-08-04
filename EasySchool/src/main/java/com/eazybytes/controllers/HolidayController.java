package com.eazybytes.controllers;

import com.eazybytes.model.Holiday;
import com.eazybytes.services.HolidayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author VietDev
 * @date 26/07/2023
 * @role
 */
@Controller
@RequiredArgsConstructor
public class HolidayController {
    private final HolidayService holidayService;
    @GetMapping("/holidays")
    public String displayHolidaysPage(@RequestParam(required = false) boolean festival,
                                      @RequestParam(required = false) boolean federal,
                                      Model model) {
//        List<Holiday> holidays = Arrays.asList(
//                new Holiday(" Jan 1 ", "New Year's Day", Holiday.Type.FESTIVAL),
//                new Holiday(" Oct 31 ", "Halloween", Holiday.Type.FESTIVAL),
//                new Holiday(" Nov 24 ", "Thanksgiving Day", Holiday.Type.FESTIVAL),
//                new Holiday(" Dec 25 ", "Christmas", Holiday.Type.FESTIVAL),
//                new Holiday(" Jan 17 ", "Martin Luther King Day", Holiday.Type.FEDERAL),
//                new Holiday(" July 4 ", "Independence Day", Holiday.Type.FEDERAL),
//                new Holiday(" Sep 5 ", "Labor Day", Holiday.Type.FEDERAL),
//                new Holiday(" Nov 11 ", "Veterans Day", Holiday.Type.FEDERAL)
//        );
        List<Holiday> holidays = holidayService.getAllHolidays();
//        filter by Holiday type and send to the UI
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList()));
        }
//        whether show holiday type
        model.addAttribute("festival", festival);
        model.addAttribute("federal", federal);
        return "holidays.html";
    }

}

