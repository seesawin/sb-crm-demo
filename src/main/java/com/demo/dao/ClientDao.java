package com.demo.dao;

import com.demo.bean.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client, Integer>, ClientDaoCustom {
}