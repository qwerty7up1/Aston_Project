package com.example.aston_project.dao;

import com.example.aston_project.DbUtil;
import com.example.aston_project.entity.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO implements AbstractDAO<Project> {

    private Connection connection;

    public ProjectDAO() {
        connection = DbUtil.getConnection();
    }

    @Override
    public void add(Project project) {
        String sql = "insert into project (title) values (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, project.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Project> getAll() {
        List<Project> projectList = new ArrayList<>();
        String sql = "select id, title from project";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setTitle(resultSet.getString("fist_name"));
                projectList.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectList;
    }

    @Override
    public Project getById(int id) {
        Project project = new Project();
        String sql = "select id, title from project where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                project.setId(resultSet.getInt("id"));
                project.setTitle(resultSet.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public void update(Project project) {
        String sql = "update project set id = ?, title = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, project.getId());
            preparedStatement.setString(2, project.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Project project) {
        String sql = "delete from project where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, project.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
