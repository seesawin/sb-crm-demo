package com.demo.dao;

import com.demo.bean.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDao extends JpaRepository<UserRole, Integer> {
    List<UserRole> findUserRoleByUserId(Integer userId);
}
