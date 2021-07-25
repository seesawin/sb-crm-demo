package com.demo.bean.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ClientVO {
    private Integer id;

    private Integer companyId;

    private String name;

    private String email;

    private String phone;

    private String createdBy;

    private Date createdAt;

    private String updatedBy;

    private Date updatedAt;
}
