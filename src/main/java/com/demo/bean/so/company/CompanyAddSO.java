package com.demo.bean.so.company;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class CompanyAddSO {
    @Valid
    private List<CompanyAdd> clients;
}