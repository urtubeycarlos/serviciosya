package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.entity.Client;
import com.capgemini.serviciosya.dao.Dao;

public class ClientDao extends Dao<Client> {

    public ClientDao(){
        super(Client.class);
    }

    public Client findByEmail(String email){
        return findBy("email", email);
    }

    public Client findByDni(Integer dni){
        return findBy("dni", dni.toString());
    }

    public Client findByPhone(String phone){
        return findBy("phone", phone);
    }
}