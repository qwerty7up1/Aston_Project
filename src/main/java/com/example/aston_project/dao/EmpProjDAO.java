package com.example.aston_project.dao;

import com.example.aston_project.Util;
import com.example.aston_project.entity.Employee_project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpProjDAO extends Util implements EPDAO<Employee_project> {

    @Override
    public void add(Employee_project employee_project) {
        PreparedStatement preparedStatement = null;
        String sql = "insert into Employee_project (employee_id, project_id) values (?,?)";

        try {
            preparedStatement = getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, employee_project.getEmployee_id());
            preparedStatement.setInt(2, employee_project.getProject_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
            closeConnection();
        }
    }

    @Override
    public List<Employee_project> getAll() {

        List<Employee_project> employee_projectList = new ArrayList<>();

        String sql = "select employee_id, project_id from employee_project";

        Statement statement = null;

        try {
            statement = getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Employee_project employee_project = new Employee_project();
                employee_project.setEmployee_id(resultSet.getInt("employee_id"));
                employee_project.setProject_id(resultSet.getInt("project_id"));

                employee_projectList.add(employee_project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
            closeConnection();
        }
        return employee_projectList;
    }

    @Override
    public Employee_project getById(int empId, int projId) {
        PreparedStatement preparedStatement = null;

        String sql = "select employee_id, project_id from employee_project where employee_id = ? and project_id = ?";

        Employee_project employee_project = new Employee_project();
        try {
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, employee_project.getEmployee_id());
            preparedStatement.setInt(2, employee_project.getProject_id());

            ResultSet resultSet = preparedStatement.executeQuery();

            employee_project.setEmployee_id(resultSet.getInt("employee_id"));
            employee_project.setProject_id(resultSet.getInt("project_id"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
            closeConnection();
        }
        return employee_project;
    }

    @Override
    public void update(Employee_project employee_project) {
        PreparedStatement preparedStatement = null;
        String sql = "update employee_project set employee_id = ? and project_id = ?";

        try {
            preparedStatement = getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, employee_project.getEmployee_id());
            preparedStatement.setInt(2, employee_project.getProject_id());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
            closeConnection();
        }
    }

    @Override
    public void remove(Employee_project employee_project) {

        PreparedStatement preparedStatement = null;

        String sql = "delete from employee_project where employee_id = ? and project_id = ?";

        try {
            preparedStatement = getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, employee_project.getEmployee_id());
            preparedStatement.setInt(1, employee_project.getProject_id());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
            closeConnection();
        }

    }
}
