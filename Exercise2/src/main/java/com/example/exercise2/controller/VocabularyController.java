package com.example.exercise2.controller;

import com.example.exercise2.model.Vocabulary;
import com.example.exercise2.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VocabularyController {
    @Autowired
    private VocabularyService vocabularyService;
    @GetMapping("/vocabulary")
    public List<Vocabulary> getAllVocabularies(){
        return vocabularyService.getAllVocabularies();
    }
}

