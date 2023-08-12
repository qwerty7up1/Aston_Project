package com.example.aston_project;

import com.example.aston_project.dao.AddressDAO;
import com.example.aston_project.dao.EmpProjDAO;
import com.example.aston_project.dao.EmployeeDAO;
import com.example.aston_project.dao.ProjectDAO;
import com.example.aston_project.entity.Address;
import com.example.aston_project.entity.Employee;
import com.example.aston_project.entity.Employee_project;
import com.example.aston_project.entity.Project;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        AddressDAO addressDAO = new AddressDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        ProjectDAO projectDAO = new ProjectDAO();
        EmpProjDAO empProjDAO = new EmpProjDAO();

        Address address = new Address();
        address.setId(1);
        address.setCountry("RF");
        address.setCity("NN");
        address.setStreet("Korably");
        address.setPost_code("603000");

        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirst_name("first");
        employee.setLast_name("second");
        employee.setBirthday(Date.valueOf(LocalDate.now()));
        employee.setAddress_id(1);

        Project project = new Project();
        project.setId(1);
        project.setTitle("title1");

        Employee_project employee_project = new Employee_project();
        employee_project.setEmployee_id(1);
        employee_project.setProject_id(1);

        try {
            addressDAO.add(address);
            employeeDAO.add(employee);
            projectDAO.add(project);
            empProjDAO.add(employee_project);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
