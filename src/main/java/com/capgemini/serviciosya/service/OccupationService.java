
package com.capgemini.serviciosya.service;


import java.util.List;

import com.capgemini.serviciosya.beans.domain.Occupation;
import com.capgemini.serviciosya.dao.IOccupationDao;
import sun.plugin.util.PluginConsoleController;


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