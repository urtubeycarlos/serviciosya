
package com.capgemini.serviciosya.service;

import com.capgemini.serviciosya.dao.orm.OccupationDao;

public class OccupationService {

    private OccupationDao _occupationDao;

    private OccupationService () {

        super ();
    }

    public OccupationService(OccupationDao occupationDao) {

        super ();
        _occupationDao = occupationDao;

    }



}