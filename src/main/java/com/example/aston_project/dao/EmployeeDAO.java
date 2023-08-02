package com.example.aston_project.dao;

import com.example.aston_project.entity.Address;
import com.example.aston_project.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    //create
    void add(Employee employee);

    //readAll
    List<Employee> getAll();

    //readById
    Employee getById(int id);

    //update
    void update(Employee employee);

    //delete
    void remove(Employee employee);
}
