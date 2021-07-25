package com.demo.service;

import com.demo.bean.model.Client;
import com.demo.bean.query.ClientQuery;
import com.demo.bean.so.client.ClientAddSO;
import com.demo.bean.so.client.ClientDeleteSO;
import com.demo.bean.so.client.ClientUpdateSO;
import com.demo.bean.vo.ClientVO;
import com.demo.dao.ClientDao;
import lombok.extern.slf4j.Slf4j;
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
public class ClientService {
    @Resource
    private ClientDao clientDao;

    /**
     * query User
     *
     * @param clientQuery
     * @return
     */
    public List<ClientVO> query(ClientQuery clientQuery) {
        //query
        List<Client> clients = clientDao.getUserByUserQuery(clientQuery);
        //create vo
        return clients.stream().map(it -> {
            ClientVO vo = new ClientVO();
            BeanUtils.copyProperties(it, vo);
            return vo;
        }).collect(Collectors.toList());
    }

    /**
     * add user
     *
     * @param userCreateSO
     */
    public void add(ClientAddSO userCreateSO) {
        List<Client> clients = userCreateSO.getClients().stream().map(it -> {
            Client user = new Client();
            BeanUtils.copyProperties(it, user);
            user.init();
            return user;
        }).collect(Collectors.toList());
        clientDao.saveAll(clients);
    }

    /**
     * update user
     *
     * @param userUpdateSO
     */
    public void update(ClientUpdateSO userUpdateSO) throws Exception {
        Client client = clientDao.findById(userUpdateSO.getId()).orElse(null);
        if (Objects.isNull(client)) {
            throw new Exception("client is not found");
        }
        // TODO check the updatedAt is equals to old's, if it is not same throw exception
        BeanUtils.copyProperties(userUpdateSO, client);
        client.update();
        clientDao.saveAndFlush(client);
    }

    /**
     * delete users
     *
     * @param userDeleteSO
     */
    @Transactional
    public void delete(ClientDeleteSO userDeleteSO) {
        clientDao.deleteAllByIdInBatch(userDeleteSO.getIds());
    }

}
