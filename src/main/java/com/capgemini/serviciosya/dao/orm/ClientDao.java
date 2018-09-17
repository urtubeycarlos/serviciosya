package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.Client;
import com.capgemini.serviciosya.dao.Dao;

public class ClientDao extends Dao<Client> {

    public ClientDao(){
        super(Client.class);
    }

}