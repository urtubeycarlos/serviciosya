package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.entity.Provider;
import com.capgemini.serviciosya.dao.Dao;

public class ProviderDao extends Dao<Provider> {

    public ProviderDao(){
        super(Provider.class);
    }

    public Provider findByEmail(String email){
        return findBy("email", email);
    }

    public Provider findByDni(Integer dni){
        return findBy("dni", dni.toString());
    }

    public Provider findByPhone(String phone){
        return findBy("phone", phone);
    }

}

