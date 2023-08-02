package com.example.aston_project.service;

import com.example.aston_project.dao.AddressDAO;
import com.example.aston_project.entity.Address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class AddressService implements AddressDAO {

    Connection connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee", "postgres", "qwe");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void add(Address address) {

    }

    @Override
    public List<Address> getAll() {
        return null;
    }

    @Override
    public Address getById(int id) {
        return null;
    }

    @Override
    public void update(Address address) {

    }

    @Override
    public void remove(Address address) {

    }
}
