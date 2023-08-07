package com.eazybytes.services;

import com.eazybytes.model.Person;
import com.eazybytes.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author VietDev
 * @date 07/08/2023
 * @role
 */
@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Person createUser(Person person){
        return personRepository.save(person);
    }

}

