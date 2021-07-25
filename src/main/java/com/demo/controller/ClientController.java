package com.demo.controller;

import com.demo.bean.query.ClientQuery;
import com.demo.bean.so.client.ClientAddSO;
import com.demo.bean.so.client.ClientDeleteSO;
import com.demo.bean.so.client.ClientUpdateSO;
import com.demo.bean.vo.CommonVO;
import com.demo.service.ClientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Resource
    private ClientService clientService;

    @PostMapping("/view")
    @PreAuthorize("hasAnyAuthority('super','manager','operator')")
    @ApiOperation(value = "all roles can access", authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity<?> clientQuery(@RequestBody ClientQuery clientQuery) {
        return ResponseEntity.ok(CommonVO.success(clientService.query(clientQuery)));
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('super','operator')")
    @ApiOperation(value = "super, operator can access", authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity<?> add(@Valid @RequestBody ClientAddSO clientAddSO) {
        clientService.add(clientAddSO);
        return ResponseEntity.ok(CommonVO.success());
    }

    @PostMapping("/batch/add")
    @PreAuthorize("hasAnyAuthority('super','operator')")
    @ApiOperation(value = "super, operator can access", authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity<?> batchAdd(@Valid @RequestBody ClientAddSO clientAddSO) {
        clientService.add(clientAddSO);
        return ResponseEntity.ok(CommonVO.success());
    }

    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('super','manager')")
    @ApiOperation(value = "super, manager can access", authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity<?> update(@Valid @RequestBody ClientUpdateSO clientUpdateSO) throws Exception {
        clientService.update(clientUpdateSO);
        return ResponseEntity.ok(CommonVO.success());
    }

    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('super','manager')")
    @ApiOperation(value = "super, manager can access", authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity<?> delete(ClientDeleteSO clientDeleteSO) {
        clientService.delete(clientDeleteSO);
        return ResponseEntity.ok(CommonVO.success());
    }

}
