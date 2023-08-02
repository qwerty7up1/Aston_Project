package com.example.aston_project.dao;

import com.example.aston_project.entity.Address;

import java.util.List;

public interface AddressDAO {

    //create
    void add(Address address);

    //readAll
    List<Address> getAll();

    //readById
    Address getById(int id);

    //update
    void update(Address address);

    //delete
    void remove(Address address);

}
