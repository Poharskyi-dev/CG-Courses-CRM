package com.opencourse.cgcoursescrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CgCoursesCrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CgCoursesCrmApplication.class, args);
    }

}
