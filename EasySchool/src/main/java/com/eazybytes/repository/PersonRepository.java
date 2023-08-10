package com.eazybytes.repository;

import com.eazybytes.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person getByEmail(String email);
}
