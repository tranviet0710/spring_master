package com.eazybytes.implementations;

import com.eazybytes.interfaces.Speakers;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SonySpeakers implements Speakers {

    @Override
    public String makeSound() {
        return "Playing music with Sony Speakers";
    }
}

