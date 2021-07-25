package com.demo.dao;

import com.demo.bean.model.Client;
import com.demo.bean.query.ClientQuery;

import java.util.List;

public interface ClientDaoCustom {
    List<Client> getUserByUserQuery(ClientQuery clientQuery);
}
