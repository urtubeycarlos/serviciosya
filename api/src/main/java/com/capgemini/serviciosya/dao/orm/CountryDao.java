package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.entity.Country;
import com.capgemini.serviciosya.dao.Dao;

public class CountryDao extends Dao<Country> {

    public CountryDao(){
        super(Country.class);
    }

    public Country findByName(String name){
        return findBy("name", name);
    }

}