package com.eazybytes.services;

import com.eazybytes.model.EazyClass;
import com.eazybytes.repository.EazyClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author VietDev
 * @date 11/08/2023
 * @role
 */
@Service
@RequiredArgsConstructor
public class EazyClassService {
    private final EazyClassRepository eazyClassRepository;

    public EazyClass save(EazyClass eazyClass){
        return eazyClassRepository.save(eazyClass);
    }

    public List<EazyClass> getAllClasses(){
        return eazyClassRepository.findAll();
    }

    public EazyClass findClassByName(String name) {
        return eazyClassRepository.findByName(name);
    }

    public EazyClass getClassById(Integer classId) {
        return eazyClassRepository.findById(classId).orElse(null);
    }

    public void delete(EazyClass eazyClass) {
        eazyClassRepository.delete(eazyClass);
    }
}

