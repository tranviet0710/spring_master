package com.eazybytes.repository;

import com.eazybytes.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {
    Courses findByName(String name);
}
