package com.demo.dao;

import com.demo.bean.model.Company;
import com.demo.bean.query.CompanyQuery;

import java.util.List;

public interface CompanyDaoCustom {
    List<Company> getCompanyByCompanyQuery(CompanyQuery companyQuery);
}
