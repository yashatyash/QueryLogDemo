package com.yash.jdbcTemplate;

import com.yash.hikari.CustomHikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by yash.raj on 30, May, 2023
 * Project Name - QueryLogDemo
 * IDE Used - IntelliJ IDEA
 */
public class JDBCTemplateFactory extends JdbcTemplate {

    public static JdbcTemplate getJdbcTemplate()
    {
        HikariDataSource dataSource = CustomHikariConfig.getDataSource();
        return new JdbcTemplate(dataSource);
    }
}
