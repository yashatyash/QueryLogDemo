package com.yash;

import com.yash.jdbcTemplate.JDBCTemplateFactory;
import com.yash.model.Employee;
import com.yash.provider.AddEmployeeDataProvider;
import com.yash.provider.GetEmployeeDataProvider;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by yash.raj on 30, May, 2023
 * Project Name - QueryLogDemo
 * IDE Used - IntelliJ IDEA
 */
public class MainClass {

    public static void getEmployee() {
        JdbcTemplate jdbcTemplate = JDBCTemplateFactory.getJdbcTemplate();
        final GetEmployeeDataProvider provider = new GetEmployeeDataProvider();
        String query = provider.getReadQuery();
        List<Employee> employeeList = jdbcTemplate.query(query,
                (PreparedStatement ps) -> provider.mapTo(ps),
                (resultSet, i) -> (Employee) provider.mapFrom(resultSet));
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    public static void createNewEmployee() {
        JdbcTemplate jdbcTemplate = JDBCTemplateFactory.getJdbcTemplate();
        AddEmployeeDataProvider provider = new AddEmployeeDataProvider();
        String query = provider.getWriteQuery();
        jdbcTemplate.update(query, (PreparedStatement ps) -> provider.mapTo(ps));
    }
}
