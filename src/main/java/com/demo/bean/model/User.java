package com.demo.bean.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private Date updatedAt;

    public static User init(String userName, String password) {
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        user.setCreatedBy("system");
        user.setCreatedAt(new Date());
        user.setUpdatedBy("system");
        user.setUpdatedAt(new Date());
        return user;
    }
}