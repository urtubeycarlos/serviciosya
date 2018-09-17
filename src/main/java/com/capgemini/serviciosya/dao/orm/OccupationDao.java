package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.Occupation;
import com.capgemini.serviciosya.dao.Dao;

public class OccupationDao extends Dao<Occupation>{

    public OccupationDao(){
        super(Occupation.class);
    }

}