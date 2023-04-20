package com.eazybytes.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"com.eazybytes.implementations", "com.eazybytes.services"})
@ComponentScan(basePackageClasses = {com.eazybytes.beans.Vehicle.class, com.eazybytes.beans.Person.class})
public class ProjectConfig {

}

