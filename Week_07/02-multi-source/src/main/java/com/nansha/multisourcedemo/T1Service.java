package com.nansha.multisourcedemo;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;


public interface T1Service {
    void insertOne(DataSource dataSource, String sql);
    List<Map<String, Object>> query(DataSource dataSource, String sql);
}
