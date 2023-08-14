package com.example.aston_project.service;

import com.example.aston_project.dao.EmpProjDAO;
import com.example.aston_project.entity.Employee_project;

import java.util.List;

public class EmpProjServiceImpl implements EmpProjService<Employee_project> {

    EmpProjDAO empProjDAO = new EmpProjDAO();

    @Override
    public void add(Employee_project e) {
        empProjDAO.add(e);
    }

    @Override
    public List<Employee_project> getAll() {
        return empProjDAO.getAll();
    }

    @Override
    public Employee_project getById(int empId, int projId) {
        return empProjDAO.getById(empId, projId);
    }

    @Override
    public void update(Employee_project e, int empId, int projId) {
        e.setEmployee_id(empId);
        e.setProject_id(projId);
        empProjDAO.update(e, empId, projId);
    }

    @Override
    public void remove(Employee_project e, int empId, int projId) {
        empProjDAO.remove(e, empId, projId);
    }
}
