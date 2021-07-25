package com.demo.bean.so.company;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CompanyAdd {
    @NotBlank
    private String name;
    @NotBlank
    private String address;
}


