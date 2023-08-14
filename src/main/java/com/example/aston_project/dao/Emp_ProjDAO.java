package com.example.aston_project.dao;

import java.util.List;

interface Emp_ProjDAO <Employee_project> {
    //create
    void add(Employee_project e);

    //readAll
    List<Employee_project> getAll ();

    //readById
    Employee_project getById(int empId, int projId);

    //update
    void update(Employee_project e, int empId, int projId);

    //delete
    void remove(Employee_project e, int empId, int projId);
}
