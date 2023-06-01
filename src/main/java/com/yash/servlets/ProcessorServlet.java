package com.yash.servlets;

import com.yash.MainClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yash.raj on 30, May, 2023
 * Project Name - QueryLogDemo
 * IDE Used - IntelliJ IDEA
 */
public class ProcessorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("Command is: " + command);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String command = req.getParameter("command");
            if (command.contains("get")) {
                resp.setContentType("text/html");
                PrintWriter writer = resp.getWriter();
                MainClass.getEmployee();
                writer.println("Done !!!!");
            } else if (command.contains("create")) {
                resp.setContentType("text/html");
                PrintWriter writer = resp.getWriter();
                MainClass.createNewEmployee();
                writer.println("Done !!!!");
            }
        } catch (NullPointerException exception) {
            exception.printStackTrace();
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.println("Sorry !!!!");
        }
    }
}
