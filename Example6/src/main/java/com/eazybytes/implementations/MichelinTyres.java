package com.eazybytes.implementations;

import com.eazybytes.interfaces.Tyres;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MichelinTyres implements Tyres {

    @Override
    public String rotates() {
        return "Vehicle moving with Michelin Tyres";
    }
}

