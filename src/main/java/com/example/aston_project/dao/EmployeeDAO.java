package com.example.aston_project.dao;

import com.example.aston_project.Util;
import com.example.aston_project.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends Util implements DAO<Employee> {

    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/employee", "postgres", "qwe");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Employee employee) {
        PreparedStatement preparedStatement = null;
        String sql = "insert into employee (fist_name, last_name, birthday, address_id) values (?,?,?,?)";

        try {
            preparedStatement = getConnection().prepareStatement(sql);

            preparedStatement.setString(1, employee.getFirst_name());
            preparedStatement.setString(2, employee.getLast_name());
            preparedStatement.setDate(3, employee.getBirthday());
            preparedStatement.setInt(4, employee.getAddress_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
            closeConnection();
        }
    }

    @Override
    public List<Employee> getAll() {

        List<Employee> employeeList = new ArrayList<>();

        String sql = "select id, fist_name, last_name, birthday, address_id from employee";

        Statement statement = null;

        try {
            statement = getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setFirst_name(resultSet.getString("fist_name"));
                employee.setLast_name(resultSet.getString("last_name"));
                employee.setBirthday(resultSet.getDate("birthday"));
                employee.setAddress_id(resultSet.getInt("address_id"));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
            closeConnection();
        }
        return employeeList;
    }

    @Override
    public Employee getById(int id) {
        PreparedStatement preparedStatement = null;

        String sql = "select id, fist_name, last_name, birthday, address_id from employee where id = ?";

        Employee employee = new Employee();
        try {
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            employee.setId(resultSet.getInt("id"));
            employee.setFirst_name(resultSet.getString("fist_name"));
            employee.setLast_name(resultSet.getString("last_name"));
            employee.setBirthday(resultSet.getDate("birthday"));
            employee.setAddress_id(resultSet.getInt("address_id"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
            closeConnection();
        }
        return employee;
    }

    @Override
    public void update(Employee employee) {
        PreparedStatement preparedStatement = null;
        String sql = "update employee set id = ?, fist_name = ?, last_name = ?, birthday = ?, address_id = ?";

        try {
            preparedStatement = getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getFirst_name());
            preparedStatement.setString(3, employee.getLast_name());
            preparedStatement.setDate(4, employee.getBirthday());
            preparedStatement.setInt(4, employee.getAddress_id());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
            closeConnection();
        }
    }

    @Override
    public void remove(Employee employee) {

        PreparedStatement preparedStatement = null;

        String sql = "delete from employee where id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, employee.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
            closeConnection();
        }

    }
}
