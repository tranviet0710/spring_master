package com.example.exercise2.service;

import com.example.exercise2.model.Grammar;
import com.example.exercise2.repository.GrammarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrammarService {
    @Autowired
    private GrammarRepository grammarRepository;


    public List<Grammar> getAllGrammars(){
        return grammarRepository.findAll();
    }
}

