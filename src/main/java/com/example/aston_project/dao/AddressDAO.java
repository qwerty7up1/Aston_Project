package com.example.aston_project.dao;

import com.example.aston_project.DbUtil;
import com.example.aston_project.entity.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO implements AbstractDAO<Address> {

    private Connection connection;
    public AddressDAO(){
        connection = DbUtil.getConnection();
    }

    @Override
    public void add(Address address) {
        String sql = "insert into address (country, city, street, post_code) values (?,?,?,?)";
        try {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, address.getCountry());
                preparedStatement.setString(2, address.getCity());
                preparedStatement.setString(3, address.getStreet());
                preparedStatement.setString(4, address.getPost_code());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Address> getAll() {
        List<Address> addressList = new ArrayList<>();
        String sql = "select id, country, city, street, post_code from address";
        try {
            Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    Address address = new Address();
                    address.setId(resultSet.getInt("id"));
                    address.setCountry(resultSet.getString("country"));
                    address.setCity(resultSet.getString("city"));
                    address.setStreet(resultSet.getString("street"));
                    address.setPost_code(resultSet.getString("post_code"));
                    addressList.add(address);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressList;
    }

    @Override
    public Address getById(int id) {
        Address address = new Address();
        String sql = "select id, country, city, street, post_code from address where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                address.setId(resultSet.getInt("id"));
                address.setCountry(resultSet.getString("country"));
                address.setCity(resultSet.getString("city"));
                address.setStreet(resultSet.getString("street"));
                address.setPost_code(resultSet.getString("post_code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public void update(Address address) {
        String sql = "update address set country = ?, city = ?, street = ?, post_code = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getPost_code());
            preparedStatement.setInt(5, address.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Address address) {
        String sql = "delete from address where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, address.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
