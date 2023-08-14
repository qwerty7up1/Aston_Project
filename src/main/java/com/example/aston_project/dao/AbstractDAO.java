package com.example.aston_project.dao;

import java.util.List;

interface AbstractDAO<E> {
    //create
    void add(E e);

    //readAll
    List<E> getAll ();

    //readById
    E getById(int T);

    //update
    void update(E e, int T);

    //delete
    void remove(E e, int T);
}
