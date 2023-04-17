package com.eazybytes.config;

import com.eazybytes.beans.Person;
import com.eazybytes.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.eazybytes.beans")
public class ProjectConfig {
    @Bean
    public Vehicle vehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("ferrari");
        return vehicle;
    }

    @Bean
    public Person person(){
        Person person = new Person();
        person.setName("Tokuda");
        person.setVehicle(vehicle());
        return person;
    }
}

