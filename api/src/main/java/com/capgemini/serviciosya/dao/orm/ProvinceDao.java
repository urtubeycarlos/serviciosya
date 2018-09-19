package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.entity.Province;
import com.capgemini.serviciosya.dao.Dao;

public class ProvinceDao extends Dao<Province> {

	public ProvinceDao(){
		super(Province.class);
	}

	public Province findByName(String name){
		return findBy("name", name);
	}

}