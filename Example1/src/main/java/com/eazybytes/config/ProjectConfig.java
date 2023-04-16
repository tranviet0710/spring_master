package com.eazybytes.config;

import com.eazybytes.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {
    @Bean(name="audi888")
    Vehicle vehicle1(){
        var veh = new Vehicle();
        veh.setName("Audi 888");
        return veh;
    }

    @Bean(value="ferrari888")
    @Primary
    Vehicle vehicle2(){
        var veh = new Vehicle();
        veh.setName("Ferrari 888");
        return veh;
    }
    @Bean(value="mec888")
    Vehicle vehicle3(){
        var veh = new Vehicle();
        veh.setName("Mec888");
        return veh;
    }
}

