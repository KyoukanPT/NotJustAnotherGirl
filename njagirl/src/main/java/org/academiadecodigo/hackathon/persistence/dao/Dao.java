package org.academiadecodigo.hackathon.persistence.dao;

import java.util.List;

public interface Dao<T> {

    List<T> findAll();


    T findById(Integer id);


    T saveOrUpdate(T modelObject);


    void delete(Integer id);
}
