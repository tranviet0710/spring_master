package com.eazybytes;

import com.eazybytes.beans.Vehicle;
import com.eazybytes.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Mercedes 120");
        System.out.println("Vehicle pojo object: " + vehicle.getName());


        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle veh = context.getBean(Vehicle.class); //ambiguous if no @Primary
        System.out.println("Vehicle bean: " + veh.getName());

        Vehicle veh1 = context.getBean("audi888", Vehicle.class); //ambiguous
        System.out.println("Vehicle bean: " + veh1.getName());


        Vehicle veh2 = context.getBean("ferrari888", Vehicle.class); //ambiguous
        System.out.println("Vehicle bean: " + veh2.getName());

        Vehicle veh3 = context.getBean("mec888", Vehicle.class); //ambiguous
        System.out.println("Vehicle bean: " + veh3.getName());

        System.out.println("ABC");
    }
}