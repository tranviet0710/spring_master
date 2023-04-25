package com.example.exercise2.controller;

import com.example.exercise2.model.Grammar;
import com.example.exercise2.service.GrammarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GrammarController {
    @Autowired
    private GrammarService grammarService;

    @GetMapping("/grammar")
    public List<Grammar> getAllGrammars(){
        return grammarService.getAllGrammars();
    }
}

