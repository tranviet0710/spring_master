package com.example.exercise1;
import jakarta.persistence.*;

@Entity
public class Deck {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_entity_seq")
    @SequenceGenerator(name = "my_entity_seq", sequenceName = "my_entity_sequence", allocationSize = 1)
    private Integer id;
    private String name;
    private String description;
    public Deck(){

    }
    public Deck(Integer deckID, String deckName, String description) {
        this.id = deckID;
        this.name = deckName;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

