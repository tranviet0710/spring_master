package com.example.exercise2.repository;

import com.example.exercise2.model.Grammar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GrammarRepository extends JpaRepository<Grammar, UUID> {
}
