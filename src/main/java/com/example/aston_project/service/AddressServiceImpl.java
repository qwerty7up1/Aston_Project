package com.example.aston_project.service;

import com.example.aston_project.dao.AddressDAO;
import com.example.aston_project.entity.Address;

import java.util.List;

public class AddressServiceImpl implements AddressService<Address> {

    private final AddressDAO addressDAO = new AddressDAO();

    @Override
    public void add(Address address) {
        addressDAO.add(address);
    }

    @Override
    public List<Address> getAll() {
        return addressDAO.getAll();
    }

    @Override
    public Address getById(int id) {
        return addressDAO.getById(id);
    }

    @Override
    public void update(Address address) {
        addressDAO.update(address);
    }

    @Override
    public void remove(Address address) {
        addressDAO.remove(address);
    }
}
