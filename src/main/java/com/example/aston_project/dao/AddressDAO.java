package com.example.aston_project.dao;

import com.example.aston_project.Util;
import com.example.aston_project.entity.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO extends Util implements DAO<Address> {

    @Override
    public void add(Address address) {
        PreparedStatement preparedStatement = null;
        String sql = "insert into address (country, city, street, post_code) values (?,?,?,?)";

        try {
            preparedStatement = getConnection().prepareStatement(sql);

            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getPost_code());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           closePrepareStatement(preparedStatement);
           closeConnection();
        }
    }

    @Override
    public List<Address> getAll() {

        List<Address> addressList = new ArrayList<>();

        String sql = "select id, country, city, street, post_code from address";

        Statement statement = null;

        try {
            statement = getConnection().createStatement();

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
        } finally {
            closeStatement(statement);
            closeConnection();
        }
        return addressList;
    }

    @Override
    public Address getById(int id) {
        PreparedStatement preparedStatement = null;

        String sql = "select id, country, city, street, post_code from address where id = ?";

        Address address = new Address();
        try {
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            address.setId(resultSet.getInt("id"));
            address.setCountry(resultSet.getString("country"));
            address.setCity(resultSet.getString("city"));
            address.setStreet(resultSet.getString("street"));
            address.setPost_code(resultSet.getString("post_code"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(preparedStatement);
            closeConnection();
        }
        return address;
    }

    @Override
    public void update(Address address) {
        PreparedStatement preparedStatement = null;

        String sql = "update address set id = ?, country = ?, city = ?, street = ?, post_code = ?";

        try {
            preparedStatement = getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, address.getId());
            preparedStatement.setString(2, address.getCountry());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getStreet());
            preparedStatement.setString(5, address.getPost_code());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           closePrepareStatement(preparedStatement);
           closeConnection();
        }
    }

    @Override
    public void remove(Address address) {

        PreparedStatement preparedStatement = null;

        String sql = "delete from address where id = ?";

        try {
            preparedStatement = getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, address.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           closePrepareStatement(preparedStatement);
           closeConnection();
        }

    }
}
