package com.yash.provider;

import com.yash.logging.CustomLogger;
import com.yash.model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yash.raj on 30, May, 2023
 * Project Name - QueryLogDemo
 * IDE Used - IntelliJ IDEA
 */
public class GetEmployeeDataProvider {

    private static final String EMP_ID = "1";

    public String getReadQuery() {
        StringBuffer query = new StringBuffer();
        query.append("select");
//        query.append(" *");
        query.append(" first_name,");
        query.append(" last_name,");
        query.append(" salary");
        query.append(" from employee");
        query.append(" where id = ?");

        return query.toString();
    }

    public void mapTo(PreparedStatement pstmt) throws SQLException {
        pstmt.setString(1, EMP_ID);
        CustomLogger.sqlLog(pstmt.toString());
//        logQuery();
    }

    public Object mapFrom(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
//        employee.setId(rs.getInt("id"));
//        employee.setDesignation(rs.getString("designation"));
//        employee.setEmail(rs.getString("email"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setSalary(rs.getDouble("salary"));
//        employee.setIrmName(rs.getString("irm_name"));
//        employee.setPassword(rs.getString("password"));
        return employee;
    }

    private void logQuery() {
        StringBuffer query = new StringBuffer();
        query.append("select");
        query.append(" first_name,");
        query.append(" last_name,");
        query.append(" salary");
        query.append(" from employee");
        query.append(" where id = ");
        query.append(EMP_ID);

        CustomLogger.sqlLog(query.toString());
    }
}
