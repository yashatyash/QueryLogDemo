package com.yash.servlets;

import com.yash.MainClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yash.raj on 30, May, 2023
 * Project Name - QueryLogDemo
 * IDE Used - IntelliJ IDEA
 */
public class ProcessorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MainClass.getEmployee();
    }
}
