package com.example.exercise1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeckController {
    private final DeckRepository deckRepository;

    public DeckController(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    @GetMapping("/decks")
    public List<Deck> getAllDecks(){
        return deckRepository.findAll();
    }

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }
}

