package com.example.aston_project.service;

import com.example.aston_project.dao.ProjectDAO;
import com.example.aston_project.entity.Project;

import java.util.List;

public class ProjectServiceImpl implements ProjectService<Project> {

    ProjectDAO projectDAO = new ProjectDAO();

    @Override
    public void add(Project project) {
        projectDAO.add(project);
    }

    @Override
    public List<Project> getAll() {
        return projectDAO.getAll();
    }

    @Override
    public Project getById(int id) {
        return projectDAO.getById(id);
    }

    @Override
    public void update(Project project, int id, String title) {
        project.setId(id);
        project.setTitle(title);
        projectDAO.update(project, id);
    }

    @Override
    public void remove(Project project, int id) {
        projectDAO.remove(project, id);
    }
}
