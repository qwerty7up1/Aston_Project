package com.example.aston_project.dao;

import com.example.aston_project.DbUtil;
import com.example.aston_project.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements AbstractDAO<Employee> {

    private Connection connection;
    public EmployeeDAO(){
        connection = DbUtil.getConnection();
    }

    @Override
    public void add(Employee employee) {
        String sql = "insert into employee (fist_name, last_name, birthday, address_id) values (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getFirst_name());
            preparedStatement.setString(2, employee.getLast_name());
            preparedStatement.setDate(3, employee.getBirthday());
            preparedStatement.setInt(4, employee.getAddress_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "select id, fist_name, last_name, birthday, address_id from employee";
        try {
            Statement statement = connection.createStatement();
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
        }
        return employeeList;
    }

    @Override
    public Employee getById(int id) {
        Employee employee = new Employee();
        String sql = "select id, fist_name, last_name, birthday, address_id from employee where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setFirst_name(resultSet.getString("fist_name"));
                employee.setLast_name(resultSet.getString("last_name"));
                employee.setBirthday(resultSet.getDate("birthday"));
                employee.setAddress_id(resultSet.getInt("address_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void update(Employee employee) {
        String sql = "update employee set id = ?, fist_name = ?, last_name = ?, birthday = ?, address_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getFirst_name());
            preparedStatement.setString(3, employee.getLast_name());
            preparedStatement.setDate(4, employee.getBirthday());
            preparedStatement.setInt(5, employee.getAddress_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Employee employee) {
        String sql = "delete from employee where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
