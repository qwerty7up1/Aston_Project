package com.example.aston_project.service;

import com.example.aston_project.dao.EmployeeDAO;
import com.example.aston_project.entity.Employee;

import java.sql.Date;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService<Employee> {

    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    public void add(Employee employee) {
        employeeDAO.add(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    @Override
    public Employee getById(int id) {
        return employeeDAO.getById(id);
    }

    @Override
    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    @Override
    public void remove(Employee employee) {
        employeeDAO.remove(employee);
    }

}
