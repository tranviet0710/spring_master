package com.example.exercise2.service;

import com.example.exercise2.model.Lesson;
import com.example.exercise2.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons(){
        return lessonRepository.findAll();
    }
}

