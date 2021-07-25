package com.demo.dao.impl;

import com.demo.bean.model.Client;
import com.demo.bean.query.ClientQuery;
import com.demo.dao.ClientDaoCustom;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

public class ClientDaoCustomImpl implements ClientDaoCustom {
    @Resource
    JPAStreamer jpaStreamer;

    @Override
    public List<Client> getUserByUserQuery(ClientQuery clientQuery) {
        return (this.jpaStreamer.stream(Client.class).filter(it -> {
            if (clientQuery.getId() != null && !it.getId().equals(clientQuery.getId())) {
                return false;
            }
            if (clientQuery.getCompanyId() != null && !it.getCompanyId().equals(clientQuery.getCompanyId())) {
                return false;
            }
            if (clientQuery.getName() != null && !StringUtils.containsIgnoreCase(it.getName(), clientQuery.getName())) {
                return false;
            }
            if (clientQuery.getEmail() != null && !StringUtils.containsIgnoreCase(it.getEmail(), clientQuery.getEmail())) {
                return false;
            }
            if (clientQuery.getPhone() != null && !StringUtils.containsIgnoreCase(it.getPhone(), clientQuery.getPhone())) {
                return false;
            }
            return true;
        }).collect(Collectors.toList()));
    }
}
