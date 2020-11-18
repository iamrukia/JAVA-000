package com.iamrukia.week5.demo;


import com.iamrukia.starter.School;
import com.iamrukia.starter.SchoolAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {
    @Autowired
    private School school;

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SchoolAutoConfiguration.class);
        System.out.println("hi");
    }

}
