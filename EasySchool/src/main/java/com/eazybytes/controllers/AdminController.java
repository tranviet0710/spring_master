package com.eazybytes.controllers;

import com.eazybytes.model.EazyClass;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author VietDev
 * @date 11/08/2023
 * @role
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping(value =  "/displayClasses", method = {RequestMethod.GET})
    public ModelAndView displayClasses(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classes.html");
        modelAndView.addObject("eazyClass", new EazyClass());
        return modelAndView;
    }

    @RequestMapping(value =  "/displayCourses", method = {RequestMethod.GET})
    public String displayCourses(){
        return "courses.html";
    }
}

