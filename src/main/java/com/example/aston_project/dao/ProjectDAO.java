package com.example.aston_project.dao;

import com.example.aston_project.entity.Employee;
import com.example.aston_project.entity.Project;

import java.util.List;

public interface ProjectDAO {
    void add(Project project);

    //readAll
    List<Project> getAll();

    //readById
    Project getById(int id);

    //update
    void update(Project project);

    //delete
    void remove(Project project);
}
