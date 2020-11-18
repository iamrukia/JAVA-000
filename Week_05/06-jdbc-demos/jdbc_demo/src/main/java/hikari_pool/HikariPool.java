package hikari_pool;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariPool {
    private static final HikariConfig hcfg = new HikariConfig();
    private static final HikariDataSource hds;

    static {
        hcfg.setJdbcUrl("jdbc:h2:tcp://localhost:9090/mem:testdb");
        hcfg.setUsername("sa");
        hcfg.setPassword("password");
        hcfg.addDataSourceProperty("cachePrepStmts", "true");
        hcfg.addDataSourceProperty("prepStmtCacheSize", "250");
        hcfg.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        hcfg.setMaximumPoolSize(4);
        hds = new HikariDataSource(hcfg);
    }

    public static Connection getConnection() throws SQLException {
        return hds.getConnection();
    }

    private HikariPool(){}
}
