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
    void update(E e);

    //delete
    void remove(E e);
}
