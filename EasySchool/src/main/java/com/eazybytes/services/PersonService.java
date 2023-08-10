package com.eazybytes.services;

import com.eazybytes.constants.EazySchoolConstants;
import com.eazybytes.model.Person;
import com.eazybytes.model.Roles;
import com.eazybytes.repository.PersonRepository;
import com.eazybytes.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private final PasswordEncoder passwordEncoder;

    public Person createUser(Person person) {
        Roles role = roleRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        return personRepository.save(person);
    }

}

