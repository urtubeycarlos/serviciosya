package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.entity.Occupation;
import com.capgemini.serviciosya.dao.Dao;

public class OccupationDao extends Dao<Occupation>{

    public OccupationDao(){
        super(Occupation.class);
    }

    public Occupation findByName(String name){
        return findBy("name", name);
    }

}