package com.eazybytes.security;

import com.eazybytes.model.Person;
import com.eazybytes.model.Role;
import com.eazybytes.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author VietDev
 * @date 10/08/2023
 * @role
 */
@Component
@RequiredArgsConstructor
public class EazySchoolUsernamePwdAuthenticationProvider implements AuthenticationProvider {
    private final PersonRepository personRepository;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        Person person = personRepository.getByEmail(email);
        if (person != null && person.getPersonId() > 0 && pwd.equals(person.getPwd())) {
            return new UsernamePasswordAuthenticationToken(person.getName(), pwd, getGrantedAuthorities(person.getRole()));
        }
        else {
            throw new BadCredentialsException("Bad credentials!");
        }
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(Role role) {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        return grantedAuthorityList;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

