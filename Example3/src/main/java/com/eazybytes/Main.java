package com.eazybytes;

import com.eazybytes.beans.Vehicle;
import com.eazybytes.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle ve1 = new Vehicle();
        ve1.setName("mercedes1111");
        Supplier<Vehicle> mercedesSupplier = () -> ve1;

        Supplier<Vehicle> audiSupplier = () -> {
            Vehicle ve2 = new Vehicle();
            ve2.setName("audi888");
            return ve2;
        };

        Random rand = new Random();
        int x = rand.nextInt(10);
        if (x % 2 == 0) {
            context.registerBean("mercedes", Vehicle.class, mercedesSupplier);
        } else {
            context.registerBean("audi", Vehicle.class, audiSupplier);
        }
        Vehicle beanVe1 = null;
        Vehicle beanVe2 = null;
        try {
            beanVe1 = context.getBean("mercedes", Vehicle.class);
        }
        catch (NoSuchBeanDefinitionException ex){
            System.out.println("Error while creating Mercedes vehicle.");
        }
        try {
            beanVe2 = context.getBean("audi", Vehicle.class);
        }
        catch (NoSuchBeanDefinitionException ex){
            System.out.println("Error while creating Audi vehicle.");
        }

        if(null != beanVe1){
            System.out.println("Bean is: " + beanVe1.getName());
        }
        else{
            System.out.println("Bean is: " + beanVe2.getName());
        }
        context.close();
    }
}