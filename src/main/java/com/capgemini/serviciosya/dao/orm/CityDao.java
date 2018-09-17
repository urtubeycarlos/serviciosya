package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.entity.City;
import com.capgemini.serviciosya.dao.Dao;

public class CityDao extends Dao<City> {

    public CityDao() {
        super(City.class);
    }

    public City findByName(String name){
        return findBy("name", name);
    }

}