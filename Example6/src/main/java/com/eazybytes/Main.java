package com.eazybytes;

import com.eazybytes.beans.Person;
import com.eazybytes.beans.Vehicle;
import com.eazybytes.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        String[] persons = context.getBeanNamesForType(Person.class);
        Arrays.stream(persons).forEach(System.out::println);
        Person person = context.getBean(Person.class);
        String[] vehicles = context.getBeanNamesForType(Vehicle.class);
        Arrays.stream(vehicles).forEach(System.out::println);
        person.getVehicle().getVehicleService().moveVehicle();
        person.getVehicle().getVehicleService().playMusic();

        context.close();
    }
}