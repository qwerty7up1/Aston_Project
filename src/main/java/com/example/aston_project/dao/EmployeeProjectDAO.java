package com.example.aston_project.dao;

import com.example.aston_project.entity.Address;
import com.example.aston_project.entity.Employee_project;

import java.util.List;

public interface EmployeeProjectDAO {
    //create
    void add(Employee_project employee_project);

    //readAll
    List<Employee_project> getAll();

    //readById
    Employee_project getByEmployeeProjectId(int employee_id, int project_id);

    //update
    void update(Employee_project employee_project);

    //delete
    void remove(Employee_project employee_project);
        }
