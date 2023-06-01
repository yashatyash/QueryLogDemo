package com.yash.provider;

import com.yash.logging.CustomLogger;
import com.yash.model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yash.raj on 31, May, 2023
 * Project Name - QueryLogDemo
 * IDE Used - IntelliJ IDEA
 */
public class AddEmployeeDataProvider {

    private static final String IRM_NAME = "Dhanya Pillai";
    private static final String DESIGNATION = "Software Engineer";
    private static final String EMAIL = "shubham.patil@yash.com";
    private static final String FIRST_NAME = "Shubham";
    private static final String LAST_NAME = "Patil";
    private static final String PASSWORD = "abcdefgh";
    private static final String SALARY = "100000000";

    public String getWriteQuery() {
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO");
        query.append(" EMPLOYEE (");
        query.append(" irm_name,");
        query.append(" designation,");
        query.append(" email,");
        query.append("first_name,");
        query.append("last_name,");
        query.append("password,");
        query.append(" salary)");
        query.append(" VALUES(");
        query.append(" ?");
        query.append(" , ?");
        query.append(" , ?");
        query.append(" , ?");
        query.append(" , ?");
        query.append(" , ?");
        query.append(" , ?");
        query.append(" )");

        return query.toString();
    }

    public void mapTo(PreparedStatement pstmt) throws SQLException {
        pstmt.setString(1, IRM_NAME);
        pstmt.setString(2, DESIGNATION);
        pstmt.setString(3, EMAIL);
        pstmt.setString(4, FIRST_NAME);
        pstmt.setString(5, LAST_NAME);
        pstmt.setString(6, PASSWORD);
        pstmt.setString(7, SALARY);

        CustomLogger.sqlLog(pstmt.toString());
    }

    public Object mapFrom(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setDesignation(rs.getString("designation"));
        employee.setEmail(rs.getString("email"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setSalary(rs.getDouble("salary"));
        employee.setIrmName(rs.getString("irm_name"));
        employee.setPassword(rs.getString("password"));
        return employee;
    }
}
