package com.demo.bean.so.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginSO {
    @NotBlank
    private String name;
    @NotBlank
    private String password;
}
