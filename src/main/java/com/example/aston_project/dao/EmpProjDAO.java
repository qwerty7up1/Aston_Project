package com.example.aston_project.dao;

import com.example.aston_project.DbUtil;
import com.example.aston_project.entity.Employee_project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpProjDAO implements Emp_ProjDAO<Employee_project> {

    private Connection connection;
    public EmpProjDAO(){
        connection = DbUtil.getConnection();
    }

    @Override
    public void add(Employee_project employee_project) {
        String sql = "insert into Employee_project (employee_id, project_id) values (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee_project.getEmployee_id());
            preparedStatement.setInt(2, employee_project.getProject_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee_project> getAll() {
        List<Employee_project> employee_projectList = new ArrayList<>();
        String sql = "select employee_id, project_id from employee_project";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Employee_project employee_project = new Employee_project();
                employee_project.setEmployee_id(resultSet.getInt("employee_id"));
                employee_project.setProject_id(resultSet.getInt("project_id"));
                employee_projectList.add(employee_project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee_projectList;
    }

    @Override
    public Employee_project getById(int empId, int projId) {
        String sql = "select employee_id, project_id from employee_project where employee_id = ? and project_id = ?";
        Employee_project employee_project = new Employee_project();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee_project.getEmployee_id());
            preparedStatement.setInt(2, employee_project.getProject_id());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee_project.setEmployee_id(resultSet.getInt("employee_id"));
                employee_project.setProject_id(resultSet.getInt("project_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee_project;
    }

    @Override
    public void update(Employee_project employee_project, int empId, int projId) {
        String sql = "update employee_project set employee_id = ? and project_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee_project.getEmployee_id());
            preparedStatement.setInt(2, employee_project.getProject_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Employee_project employee_project, int empId, int projId) {
        String sql = "delete from employee_project where employee_id = ? and project_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, empId);
            preparedStatement.setInt(1, projId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
