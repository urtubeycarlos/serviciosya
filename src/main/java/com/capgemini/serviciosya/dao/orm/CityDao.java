package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.City;
import com.capgemini.serviciosya.dao.Dao;

public class CityDao extends Dao<City> {

    public CityDao() {
        super(City.class);
    }

}