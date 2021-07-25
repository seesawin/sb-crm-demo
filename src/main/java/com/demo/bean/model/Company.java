package com.demo.bean.model;


import lombok.Data;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private Date updatedAt;

    public void init() {
        this.createdBy = SecurityContextHolder.getContext().getAuthentication().getName();
        this.createdAt = new Date();
        this.updatedBy = SecurityContextHolder.getContext().getAuthentication().getName();
        this.updatedAt = new Date();
    }

    public void update() {
        this.updatedBy = SecurityContextHolder.getContext().getAuthentication().getName();
        this.updatedAt = new Date();
    }
}