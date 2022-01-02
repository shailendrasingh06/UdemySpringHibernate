package com.manom.jdbc;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;

public class TestJDBC {

    public static void main(String[] args) {
        String jdbcURl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user="hbstudent";
        String pass="hbstudent";
        System.out.println("Connecting to databse - " + jdbcURl);
        try {

            Connection conn = DriverManager.getConnection(jdbcURl, user, pass);
            System.out.println("Connected successfully!!!");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
