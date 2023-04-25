package com.example.exercise2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="grammar")
public class Grammar {
    @Id
    @Column(columnDefinition = "id", updatable = false)
    private UUID id;

    @Column(name="grammar")
    private String grammar;

    @Column(name="description")
    private String description;
    @Column(name="explanation")
    private String explanation;

    @ManyToMany(mappedBy="grammars")
    @JsonBackReference
    private List<Lesson> lessons;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getGrammar() {
        return grammar;
    }

    public void setGrammar(String grammar) {
        this.grammar = grammar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}

