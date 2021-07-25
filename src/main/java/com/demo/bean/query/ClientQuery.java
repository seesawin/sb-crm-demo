package com.demo.bean.query;

import lombok.Data;

@Data
public class ClientQuery {
    private Integer id;

    private Integer companyId;
    
    private String name;

    private String email;

    private String phone;
}
