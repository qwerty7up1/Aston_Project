package com.example.aston_project.service;

import java.sql.Date;
import java.util.List;

public interface ProjectService <E>{
    //create
    void add(E e);

    //readAll
    List<E> getAll ();

    //readById
    E getById(int id);

    //update
    void update(E e, int id, String title);

    //delete
    void remove(E e, int id);
}
