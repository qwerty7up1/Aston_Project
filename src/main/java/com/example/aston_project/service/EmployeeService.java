package com.example.aston_project.service;

import java.sql.Date;
import java.util.List;

public interface EmployeeService<E> {
    //create
    void add(E e);

    //readAll
    List<E> getAll ();

    //readById
    E getById(int id);

    //update
    void update(E e, int id, String first_name, String last_name, Date birthday, int address_id);

    //delete
    void remove(E e, int id);
}
