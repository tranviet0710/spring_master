package com.example.exercise2.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "lesson")
public class Lesson {
    @Id
    @Column(columnDefinition = "id", updatable = false)
    private UUID id;

    @Column(name="number")
    private Integer lessonNumber;
    @Column(name="title", length = 50)
    private String lessonTitle;
    @Column(name="text", length = 500)
    private String text;
    @Column(name="audio", length = 50)
    private String audio;
    @Column(name="translation", length = 1000)
    private String translation;
    @Column(name="others", length = 500)
    private String others;

    @ManyToMany
    @JoinTable(name = "lesson_vocab",
    joinColumns = @JoinColumn(name = "lesson_id"),
    inverseJoinColumns = @JoinColumn(name="vocab_id"))
    @JsonManagedReference
    public List<Vocabulary> vocabularies;


    @ManyToMany
    @JoinTable(name = "lesson_grammar",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name="grammar_id"))
    @JsonManagedReference
    public List<Grammar> grammars;

    public List<Grammar> getGrammars() {
        return grammars;
    }

    public void setGrammars(List<Grammar> grammars) {
        this.grammars = grammars;
    }

    public List<Vocabulary> getVocabularies() {
        return vocabularies;
    }

    public void setVocabularies(List<Vocabulary> vocabularies) {
        this.vocabularies = vocabularies;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(Integer lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", lessonNumber=" + lessonNumber +
                ", lessonTitle='" + lessonTitle + '\'' +
                ", text='" + text + '\'' +
                ", audio='" + audio + '\'' +
                ", translation='" + translation + '\'' +
                ", others='" + others + '\'' +
                '}';
    }
}

