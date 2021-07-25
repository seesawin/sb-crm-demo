package com.demo.dao.impl;

import com.demo.bean.model.Company;
import com.demo.bean.query.CompanyQuery;
import com.demo.dao.CompanyDaoCustom;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyDaoCustomImpl implements CompanyDaoCustom {
    @Resource
    JPAStreamer jpaStreamer;

    @Override
    public List<Company> getCompanyByCompanyQuery(CompanyQuery companyQuery) {
        return (this.jpaStreamer.stream(Company.class).filter(it -> {
            if (companyQuery.getId() != null && !it.getId().equals(companyQuery.getId())) {
                return false;
            }
            if (companyQuery.getName() != null && !StringUtils.containsIgnoreCase(it.getName(), companyQuery.getName())) {
                return false;
            }
            if (companyQuery.getAddress() != null && !StringUtils.containsIgnoreCase(it.getAddress(), companyQuery.getAddress())) {
                return false;
            }
            return true;
        }).collect(Collectors.toList()));
    }
}
