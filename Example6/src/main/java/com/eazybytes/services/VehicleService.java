package com.eazybytes.services;

import com.eazybytes.interfaces.Speakers;
import com.eazybytes.interfaces.Tyres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleService {
    @Autowired
    private Tyres tyres;
    private Speakers speakers;

    public void playMusic(){
        System.out.println(speakers.makeSound());
    }

    public void moveVehicle(){
        System.out.println(tyres.rotates());
    }

    public Tyres getTyres() {
        return tyres;
    }

    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }

    public Speakers getSpeakers() {
        return speakers;
    }

    @Autowired
    public void setSpeakers(Speakers speakers) {
        this.speakers = speakers;
    }
}

