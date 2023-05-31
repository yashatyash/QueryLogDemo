package com.yash.hikari;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.util.Properties;

/**
 * Created by yash.raj on 30, May, 2023
 * Project Name - QueryLogDemo
 * IDE Used - IntelliJ IDEA
 */
public class CustomHikariConfig {

    private static HikariDataSource dataSource;

    public static HikariDataSource getDataSource() {
        if (dataSource == null) {
            Properties props = new Properties();
            props.put("driverClassName", "com.mysql.cj.jdbc.Driver");
            props.put("poolName", "test");
            props.put("jdbcUrl", "jdbc:mysql://localhost:3306/projectdemo");
            props.put("username", "root");
            props.put("password", "abi627.Y@sh");
            props.put("maximumPoolSize", 10);
            props.put("autoCommit", true);

            HikariConfig hikariConfig = new HikariConfig(props);
            hikariConfig.setDataSourceProperties(props);
            dataSource = new HikariDataSource(hikariConfig);
        }
        return dataSource;
    }
}
