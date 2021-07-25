package com.demo.dao;

import com.demo.bean.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDao extends JpaRepository<Company, Integer>, CompanyDaoCustom {
}