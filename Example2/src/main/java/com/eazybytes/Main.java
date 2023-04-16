package com.eazybytes;

import com.eazybytes.beans.Vehicle;
import com.eazybytes.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // @Component
        Vehicle veh = context.getBean(Vehicle.class);
        System.out.println("Vehicle bean: " + veh.getName());

        context.close();
    }
}