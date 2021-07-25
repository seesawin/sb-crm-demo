package com.demo.bean.so.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class SignupSO {
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    @Pattern(message = "role code error", regexp = "^super|manager|operator$")
    private String role;
}
