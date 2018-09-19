package com.capgemini.serviciosya.service;

import com.capgemini.serviciosya.dao.orm.CountryDao;

public class CountryService {

    private CountryDao _countryDao;

    private CountryService(){
        super();
    }

    public CountryService(CountryDao countryDao){
        _countryDao = countryDao;
    }

}