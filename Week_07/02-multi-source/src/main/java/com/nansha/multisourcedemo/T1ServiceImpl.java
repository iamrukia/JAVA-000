package com.nansha.multisourcedemo;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("T1Service")
public class T1ServiceImpl implements T1Service {
    @Override
    @SneakyThrows
    public void insertOne(DataSource dataSource, String sql) {
        System.out.println("insert");
        try (Connection conn = dataSource.getConnection(); Statement statement = conn.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SneakyThrows
    @SimpleReadAnnotation
    public List<Map<String, Object>> query(DataSource dataSource, String sql) {
        System.out.println("read");
        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {


            List<Map<String, Object>> entities = new ArrayList<>();
            while (rs.next()) {
                Map<String, Object> data = new HashMap<>();
                data.put("number", rs.getInt("number"));

                entities.add(data);
            }
            return entities;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
