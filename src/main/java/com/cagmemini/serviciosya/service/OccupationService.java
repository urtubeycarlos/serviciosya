
package com.cagmemini.serviciosya.service;


import java.util.List;

import com.cagmemini.serviciosya.beans.domain.Occupation;
import com.cagmemini.serviciosya.dao.IOccupationDao;


public class OccupationService {


    private IOccupationDao occupationDao;


    public OccupationService () {

        super ();
    }

    public OccupationService (IOccupationDao occupationDao) {

        super ();

        this.occupationDao = occupationDao;
    }

    public void setOccupationDao(IOccupationDao occupationDao) {

        this.occupationDao = occupationDao;
    }

    public List<Occupation> findAllOccupations () {

        return this.occupationDao.findAllOccupations ();
    }

    public void addOccupation (Occupation occupation) {

        this.occupationDao.add (occupation);
    }

    public Occupation searchOccupation (String id){
        return this.occupationDao.searchById(id);
    }

    public void deleteOccupation (String id){
        this.occupationDao.delete(id);
    }

    public void updateOccupation (String id, Occupation ocu){
        this.occupationDao.update(id, ocu);
    }


}