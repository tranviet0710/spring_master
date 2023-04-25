package com.example.exercise2.controller;

import com.example.exercise2.model.Lesson;
import com.example.exercise2.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LessonController {
    @Autowired
    private LessonService lessonService;
    @GetMapping("/lessons")
    public List<Lesson> getAllLessons(){
        return lessonService.getAllLessons();
    }
}

