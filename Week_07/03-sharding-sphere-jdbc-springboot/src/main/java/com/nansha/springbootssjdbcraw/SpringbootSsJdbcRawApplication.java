package com.nansha.springbootssjdbcraw;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Slf4j
@SpringBootApplication
public class SpringbootSsJdbcRawApplication implements CommandLineRunner {

    @Autowired
    MyDataSource myDataSource;


    public static void main(String[] args) {
        SpringApplication.run(SpringbootSsJdbcRawApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String sql = "INSERT INTO db.t1 (number) VALUES (15);";
        String sql2 = "SELECT * from db.t1 limit 5;";

        DataSource dataSource = myDataSource.getDataSource();

        log.info("ShardingMasterSlaveDataSource info::" + dataSource.getConnection().getMetaData().getURL());

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        statement.execute(sql2);
        statement.execute(sql2);

        statement.execute(sql);

        statement.execute(sql2);

    }


}
