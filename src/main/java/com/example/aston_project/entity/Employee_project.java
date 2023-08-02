package com.example.aston_project.entity;

import java.util.Objects;

public class Employee_project {
    private int project_id;
    private int employee_id;

    public Employee_project(){}

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee_project that = (Employee_project) o;
        return project_id == that.project_id && employee_id == that.employee_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(project_id, employee_id);
    }

    @Override
    public String toString() {
        return "Employee_project{" +
                "project_id=" + project_id +
                ", employee_id=" + employee_id +
                '}';
    }
}
