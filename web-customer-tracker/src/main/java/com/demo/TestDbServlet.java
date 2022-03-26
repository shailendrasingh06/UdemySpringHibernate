package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //setup connection variable
        String user = "hbstudent";
        String pass = "hbstudent";
        String connection = "jdbc:mysql://localhost:3306/web_customer_tracker?allowPublicKeyRetrieval=true&useSSL=false";
        String driver = "com.mysql.jdbc.Driver";

        try {

            PrintWriter out = resp.getWriter();

            out.println("Connecting to db: " + connection);

            Class.forName(driver);

            Connection myconn = DriverManager.getConnection(connection,user,pass);

            out.println("Successful !!!");


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
