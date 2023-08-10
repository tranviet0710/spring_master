package com.eazybytes.services;

import com.eazybytes.constants.EazySchoolConstants;
import com.eazybytes.model.Person;
import com.eazybytes.model.Role;
import com.eazybytes.repository.PersonRepository;
import com.eazybytes.repository.RoleRepository;
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
    private final RoleRepository roleRepository;

    public Person createUser(Person person) {
        Role role = roleRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRole(role);
        return personRepository.save(person);
    }

}

