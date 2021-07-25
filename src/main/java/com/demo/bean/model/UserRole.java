package com.demo.bean.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private Date updatedAt;

    public static UserRole init(Integer userId, Integer roleId) {
        UserRole userRoles = new UserRole();
        userRoles.setUserId(userId);
        userRoles.setRoleId(roleId);
        userRoles.setCreatedBy("system");
        userRoles.setCreatedAt(new Date());
        userRoles.setUpdatedBy("system");
        userRoles.setUpdatedAt(new Date());
        return userRoles;
    }
}