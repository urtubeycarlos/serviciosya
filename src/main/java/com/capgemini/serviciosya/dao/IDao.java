
package com.capgemeini.serviciosya.dao;


import java.util.List;


public interface IDao<T, I> {


    void create (T target);

    void update (T target);

    void delete (I id);

    List<T> findAll ();

    T findById (I id);
}