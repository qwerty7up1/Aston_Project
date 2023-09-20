package com.example.aston_project;

import java.sql.*;

public class DbUtil {

    public static Connection connection;
    public static Connection getConnection() {
             connection = null;
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee",
                        "postgres",
                        "qwe");
                return connection;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return connection;
        }
    }
