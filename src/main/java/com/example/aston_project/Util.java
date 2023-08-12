package com.example.aston_project;

import java.sql.*;

public class Util {
    private Connection connection;

    public Connection getConnection() {
        {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/employee", "postgres", "qwe");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public void closeConnection(){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
