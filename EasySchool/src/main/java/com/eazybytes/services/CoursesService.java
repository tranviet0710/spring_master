package com.eazybytes.services;

import com.eazybytes.model.Courses;
import com.eazybytes.repository.CoursesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author VietDev
 * @date 13/08/2023
 * @role
 */
@Service
@RequiredArgsConstructor
public class CoursesService {
    private final CoursesRepository coursesRepository;

    public List<Courses> getAllCourses() {
        return coursesRepository.findAll();
    }

    public Courses save(Courses course) {
        return coursesRepository.save(course);
    }

    public Courses findByName(String name) {
        return coursesRepository.findByName(name);
    }

    public Courses findById(Integer id) {
        return coursesRepository.findById(id).orElse(null);
    }
}

