package com.iamrukia.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConditionalOnClass(School.class)
@EnableConfigurationProperties(SchoolProperties.class)
@PropertySource("classpath:application.properties")
public class SchoolAutoConfiguration {
    @Autowired
    private SchoolProperties schoolProperties;

    @Bean
    public School school() {
        List<Integer> studentIds = schoolProperties.getStudentIds();
        List<String> studentNames = schoolProperties.getStudentNames();
        for (String name : studentNames) {
            System.out.println("name: " + name);
        }

        //here assume the size of ids and names list are equal and not 0
        List<Student> students = new ArrayList<>();
        int length = studentIds.size();
        for (int i = 0; i < length; i++) {
            Integer id = studentIds.get(i);
            String name = studentNames.get(i);
            Student student = new Student(id, name);
            students.add(student);
        }

        Klass klass = new Klass(students);
        School school = new School(klass);

        return school;
    }
}
