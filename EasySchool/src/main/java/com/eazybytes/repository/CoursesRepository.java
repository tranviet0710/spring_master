package com.eazybytes.repository;

import com.eazybytes.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "courses")
//@RepositoryRestResource(path = "courses", exported = false)
public interface CoursesRepository extends JpaRepository<Courses, Integer> {
    Courses findByName(String name);
}
