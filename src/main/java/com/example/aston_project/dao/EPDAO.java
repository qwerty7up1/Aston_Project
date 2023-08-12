package com.example.aston_project.dao;

import java.util.List;

public interface EPDAO <E> {
    //create
    abstract void add(E e);

    //readAll
    List<E> getAll ();

    //readById
    E getById(int empId, int projId);

    //update
    void update(E e);

    //delete
    void remove(E e);
}
