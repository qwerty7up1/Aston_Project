package com.example.aston_project.service;

import com.example.aston_project.dao.AddressDAO;
import com.example.aston_project.entity.Address;

import java.util.List;

public class AddressServiceImpl implements AddressService<Address> {

    AddressDAO addressDAO = new AddressDAO();

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
    public void update(Address address, int id, String country, String city, String street, String post_code) {
        address.setId(id);
        address.setCountry(country);
        address.setCity(city);
        address.setStreet(street);
        address.setPost_code(post_code);
        addressDAO.update(address, id);
    }

    @Override
    public void remove(Address address, int id) {
        addressDAO.remove(address, id);
    }
}
