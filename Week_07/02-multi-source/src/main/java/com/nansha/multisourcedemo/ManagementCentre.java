package com.nansha.multisourcedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Random;

@Component
public class ManagementCentre {

    @Autowired
    @Qualifier("master")
    DataSource masterDataSource;

    @Autowired
    @Qualifier("slave1")
    DataSource slave1DataSource;

    @Autowired
    @Qualifier("slave2")
    DataSource slave2DataSource;


    public DataSource getDefaultDataSource() {
        return masterDataSource;
    }


    // randomly use datasource 1 or 2
    public DataSource getSlaveDataSource() {
        if (System.currentTimeMillis() % 1000 > 500) {
            System.out.println("use slave 1");
            return slave1DataSource;
        }

        System.out.println("use slave 2");
        return slave2DataSource;
    }
}
