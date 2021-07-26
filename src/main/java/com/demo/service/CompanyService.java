package com.demo.service;

import com.demo.bean.model.Company;
import com.demo.bean.query.CompanyQuery;
import com.demo.bean.so.company.CompanyAddSO;
import com.demo.bean.so.company.CompanyDeleteSO;
import com.demo.bean.so.company.CompanyUpdateSO;
import com.demo.dao.CompanyDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class CompanyService {
    @Resource
    private CompanyDao companyDao;

    /**
     * query User
     *
     * @param companyQuery
     * @return
     */
    public List<Company> query(CompanyQuery companyQuery) {
        //query
        List<Company> companies = getCompanyByCompanyQuery(companyQuery);
        //create vo
        return companies.stream().map(it -> {
            Company vo = new Company();
            BeanUtils.copyProperties(it, vo);
            return vo;
        }).collect(Collectors.toList());
    }

    /**
     * add user
     *
     * @param companyAddSO
     */
    @Transactional
    public void add(CompanyAddSO companyAddSO) {
        List<Company> clients = companyAddSO.getClients().stream().map(it -> {
            Company company = new Company();
            BeanUtils.copyProperties(it, company);
            company.init();
            return company;
        }).collect(Collectors.toList());
        companyDao.saveAll(clients);
    }

    /**
     * update user
     *
     * @param companyUpdateSO
     */
    @Transactional
    public void update(CompanyUpdateSO companyUpdateSO) throws Exception {
        Company company = companyDao.findById(companyUpdateSO.getId()).orElse(null);
        if (Objects.isNull(company)) {
            throw new Exception("company is not found");
        }
        // TODO check the updatedAt is equals to old's, if it is not same throw exception
        BeanUtils.copyProperties(companyUpdateSO, company);
        company.update();
        companyDao.saveAndFlush(company);
    }

    /**
     * delete users
     *
     * @param companyDeleteSO
     */
    @Transactional
    public void delete(CompanyDeleteSO companyDeleteSO) {
        companyDao.deleteAllByIdInBatch(companyDeleteSO.getIds());
    }

    private List<Company> getCompanyByCompanyQuery(CompanyQuery companyQuery) {
        return (companyDao.findAll().stream().filter(it -> {
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
