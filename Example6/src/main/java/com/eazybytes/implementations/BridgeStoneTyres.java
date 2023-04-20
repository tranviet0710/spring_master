package com.eazybytes.implementations;

import com.eazybytes.interfaces.Tyres;
import org.springframework.stereotype.Component;

@Component
public class BridgeStoneTyres implements Tyres {

    @Override
    public String rotates() {
        return "Vehicle moving with Bridge Stone Tyres";
    }
}

