package com.example.crud_spring_boot.service;

import java.util.List;

public interface GenericService<T, ID> {

    void save(T t);
    List<T> findAll();
    void update(T t);
    void delete(ID id);
    T getById(ID id);

}
