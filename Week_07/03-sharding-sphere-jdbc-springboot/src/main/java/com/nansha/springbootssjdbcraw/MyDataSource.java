package com.nansha.springbootssjdbcraw;

import com.zaxxer.hikari.HikariDataSource;
import io.shardingsphere.api.config.MasterSlaveRuleConfiguration;
import io.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

@Slf4j
@Component
public class MyDataSource {
    private final String DRIVER = ".driver-class-name";
    private final String URL = ".url";
    private final String USERNAME = ".username";
    private final String PASSWORD = ".password";
    private final String DBS = "sharding.jdbc.datasource.names";

    @Autowired
    Environment environment;

    DataSource getDataSource() throws SQLException {
        System.out.println("mydatasource");
        // 获取数据库列表
        String[] dbs = Objects.requireNonNull(environment.getProperty(DBS)).split(",");
        log.info("DBS::" + Arrays.toString(dbs));

        MasterSlaveRuleConfiguration configuration = new MasterSlaveRuleConfiguration(dbs[0], dbs[0],
                Arrays.asList(Arrays.copyOfRange(dbs, 1, dbs.length)));
        log.info("ShardingMasterSlaveDataSource master :: " + configuration.getMasterDataSourceName());
        log.info("ShardingMasterSlaveDataSource slave :: " + configuration.getSlaveDataSourceNames());

        Properties properties = new Properties();
        properties.setProperty("sql.show", "true");

        DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(createDataSourceMap(dbs), configuration, new HashMap<>(0),
                properties);
        return dataSource;
    }
    private Map<String, DataSource> createDataSourceMap(String[] dbs) {
        Map<String, DataSource> result = new HashMap<>(dbs.length);
        for (String db: dbs) {
            log.info("Create data source ::" + db);
            result.put(db, createDataSource("sharding.jdbc.datasource." + db));
        }
        return result;
    }

    private DataSource createDataSource(String prefix) {
        log.info(DRIVER + "::" + environment.getProperty(prefix + DRIVER));
        log.info(URL + "::" + environment.getProperty(prefix + URL));
        log.info(USERNAME + "::" + environment.getProperty(prefix + USERNAME));
        log.info(PASSWORD + "::" + environment.getProperty(prefix + PASSWORD));

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(environment.getProperty(prefix + DRIVER));
        dataSource.setJdbcUrl(environment.getProperty(prefix + URL));
        dataSource.setUsername(environment.getProperty(prefix + USERNAME));
        dataSource.setPassword(environment.getProperty(prefix + PASSWORD));
        return dataSource;
    }

}
