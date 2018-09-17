package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.Country;
import com.capgemini.serviciosya.dao.Dao;

public class CountryDao extends Dao<Country> {

    public CountryDao(){
        super(Country.class);
    }

}