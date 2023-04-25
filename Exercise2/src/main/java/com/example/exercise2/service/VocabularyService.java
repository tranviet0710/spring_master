package com.example.exercise2.service;

import com.example.exercise2.model.Vocabulary;
import com.example.exercise2.repository.VocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VocabularyService {
    @Autowired
    private VocabularyRepository vocabularyRepository;

    public List<Vocabulary> getAllVocabularies(){
        return vocabularyRepository.findAll();
    }
}

