package com.demo.controller;

import com.demo.bean.query.CompanyQuery;
import com.demo.bean.so.company.CompanyAddSO;
import com.demo.bean.so.company.CompanyDeleteSO;
import com.demo.bean.so.company.CompanyUpdateSO;
import com.demo.bean.vo.CommonVO;
import com.demo.service.CompanyService;
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
@RequestMapping("/api/company")
public class CompanyController {
    @Resource
    private CompanyService companyService;

    @PostMapping("/view")
    @PreAuthorize("hasAnyAuthority('super','manager','operator')")
    @ApiOperation(value = "all roles can access", authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity<?> clientQuery(@RequestBody CompanyQuery clientQuery) {
        return ResponseEntity.ok(CommonVO.success(companyService.query(clientQuery)));
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('super','operator')")
    @ApiOperation(value = "super, operator can access", authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity<?> add(@Valid @RequestBody CompanyAddSO clientAddSO) {
        companyService.add(clientAddSO);
        return ResponseEntity.ok(CommonVO.success());
    }

    @PostMapping("/batch/add")
    @PreAuthorize("hasAnyAuthority('super','operator')")
    @ApiOperation(value = "super, operator can access", authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity<?> batchAdd(@Valid @RequestBody CompanyAddSO companyAddSO) {
        companyService.add(companyAddSO);
        return ResponseEntity.ok(CommonVO.success());
    }

    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('super','manager')")
    @ApiOperation(value = "super, manager can access", authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity<?> update(@Valid @RequestBody CompanyUpdateSO companyUpdateSO) throws Exception {
        companyService.update(companyUpdateSO);
        return ResponseEntity.ok(CommonVO.success());
    }

    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('super','manager')")
    @ApiOperation(value = "super, manager can access", authorizations = {@Authorization(value = "jwtToken")})
    public ResponseEntity<?> delete(CompanyDeleteSO companyDeleteSO) {
        companyService.delete(companyDeleteSO);
        return ResponseEntity.ok(CommonVO.success());
    }

}
