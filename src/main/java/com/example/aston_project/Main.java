package com.example.aston_project;

import com.example.aston_project.entity.Address;
import com.example.aston_project.entity.Employee;
import com.example.aston_project.entity.Project;
import com.example.aston_project.service.AddressServiceImpl;
import com.example.aston_project.service.EmployeeServiceImpl;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        AddressServiceImpl addressService = new AddressServiceImpl();
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

        Address address = new Address();
        address.setCountry("RF");
        address.setCity("NN");
        address.setStreet("K");
        address.setPost_code("603009");

        Employee employee = new Employee();
        employee.setFirst_name("first");
        employee.setLast_name("second");
        employee.setBirthday(Date.valueOf(LocalDate.now()));
        employee.setAddress_id(1);

        Project project = new Project();
        project.setTitle("title1");

        addressService.update(address, 3, "belarusia", "gomel", "lenina", "123123");
        addressService.update(address, 5, "RF", "NN", "K", "603009");
        System.out.println(addressService.getAll());

        System.out.println(addressService.getById(99));
    }
}
