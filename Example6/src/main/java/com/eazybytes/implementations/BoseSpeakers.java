package com.eazybytes.implementations;

import com.eazybytes.interfaces.Speakers;
import org.springframework.stereotype.Component;

@Component
public class BoseSpeakers implements Speakers {

    @Override
    public String makeSound() {
        return "Playing music with Bose Speakers";
    }
}

