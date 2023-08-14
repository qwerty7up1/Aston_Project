package com.example.aston_project.dao;

import com.example.aston_project.Util;
import com.example.aston_project.entity.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO extends Util implements AbstractDAO<Project> {

    @Override
    public void add(Project project) {
        PreparedStatement preparedStatement = null;
        String sql = "insert into project (title) values (?)";

        try {
            preparedStatement = getConnection().prepareStatement(sql);

            preparedStatement.setString(1, project.getTitle());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
            closeConnection();
        }
    }

    @Override
    public List<Project> getAll() {

        List<Project> projectList = new ArrayList<>();

        String sql = "select id, title from project";

        Statement statement = null;

        try {
            statement = getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setTitle(resultSet.getString("fist_name"));

                projectList.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
            closeConnection();
        }
        return projectList;
    }

    @Override
    public Project getById(int id) {
        PreparedStatement preparedStatement = null;

        String sql = "select id, title from project where id = ?";

        Project project = new Project();
        try {
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                project.setId(resultSet.getInt("id"));
                project.setTitle(resultSet.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
            closeConnection();
        }
        return project;
    }

    @Override
    public void update(Project project, int id) {
        PreparedStatement preparedStatement = null;
        String sql = "update project set id = ?, title = ?";

        try {
            preparedStatement = getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, project.getId());
            preparedStatement.setString(2, project.getTitle());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
            closeConnection();
        }
    }

    @Override
    public void remove(Project project, int id) {

        PreparedStatement preparedStatement = null;

        String sql = "delete from project where id = ?";

        try {
            preparedStatement = getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, project.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
            closeConnection();
        }

    }
}
