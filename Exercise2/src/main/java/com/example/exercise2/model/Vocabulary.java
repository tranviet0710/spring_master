package com.example.exercise2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "vocabulary")
public class Vocabulary {
    @Id
    @Column(columnDefinition = "id", updatable = false)
    private UUID id;

    @Column(name="vocab")
    private String vocab;

    @Column(name="vn_definition")
    private String vnDefinition;

    @Column(name="en_definition")
    private String enDefinition;

    @Column(name="audio")
    private String audio;

    @Column(name="image")
    private String image;

    @Column(name="vocabtype")
    private String vocabType;

    @Column(name="example")
    private String example;

    @ManyToMany(mappedBy = "vocabularies")
    @JsonBackReference
    private List<Lesson> lessons;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getVocab() {
        return vocab;
    }

    public void setVocab(String vocab) {
        this.vocab = vocab;
    }

    public String getVnDefinition() {
        return vnDefinition;
    }

    public void setVnDefinition(String vnDefinition) {
        this.vnDefinition = vnDefinition;
    }

    public String getEnDefinition() {
        return enDefinition;
    }

    public void setEnDefinition(String enDefinition) {
        this.enDefinition = enDefinition;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVocabType() {
        return vocabType;
    }

    public void setVocabType(String vocabType) {
        this.vocabType = vocabType;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}

