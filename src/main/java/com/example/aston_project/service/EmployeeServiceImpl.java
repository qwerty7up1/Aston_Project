package com.example.aston_project.service;

import com.example.aston_project.dao.EmployeeDAO;
import com.example.aston_project.entity.Employee;

import java.sql.Date;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService<Employee> {

    EmployeeDAO employeeDAO = new EmployeeDAO();

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
    public void update(Employee employee, int id, String first_name, String last_name, Date birthday, int address_id) {
        employee.setId(id);
        employee.setFirst_name(first_name);
        employee.setLast_name(last_name);
        employee.setBirthday(birthday);
        employee.setAddress_id(address_id);
        employeeDAO.update(employee, id);
    }

    @Override
    public void remove(Employee employee, int id) {
        employeeDAO.remove(employee, id);
    }
}
