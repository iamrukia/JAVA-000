package com.nansha.multisourcedemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class MultisourcedemoApplication implements CommandLineRunner {

    @Autowired
    Environment environment;

    @Autowired
    ManagementCentre managementCentre;

    @Autowired
    T1ServiceImpl t1Service;

    public static void main(String[] args) {

        SpringApplication.run(MultisourcedemoApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("===========================end");
        System.out.println(environment.getProperty("master.datasource.url"));

        String sql = "INSERT INTO db.t1 (number) VALUES (5)";
        t1Service.insertOne(managementCentre.getDefaultDataSource(),sql);


        String sql2 = "SELECT * from db.t1;";
        List<Map<String, Object>> entities = t1Service.query(managementCentre.getDefaultDataSource(),sql2);
        for(Map item: entities){
            System.out.println(item.toString());
        }
    }
}
