package com.demo.bean.so.client;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ClientUpdateSO {
    @NotNull
    private Integer id;
    @NotNull
    private Integer companyId;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String phone;
}
