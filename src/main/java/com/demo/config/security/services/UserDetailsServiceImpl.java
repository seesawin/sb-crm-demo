package com.demo.config.security.services;

import com.demo.bean.model.Role;
import com.demo.bean.model.User;
import com.demo.bean.model.UserRole;
import com.demo.dao.RoleDao;
import com.demo.dao.UserDao;
import com.demo.dao.UserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserDao userDao;
    @Autowired
    UserRoleDao userRoleDao;
    @Autowired
    RoleDao roleDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //get user
        Optional<User> userOpt = userDao.findAll().stream().filter(users -> users.getName().equals(username)).findFirst();
        if (!userOpt.isPresent()) {
            throw new UsernameNotFoundException("user not found with username: " + username);
        }
        User user = userOpt.get();
        //get role
        List<Role> roles = roleDao.findAll();
        List<UserRole> userRoles = userRoleDao.findUserRoleByUserId(user.getId());
        List<Integer> roleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList());
        List<Role> rolesForUser = roles.stream().filter(it -> roleIds.contains(it.getId())).collect(Collectors.toList());
        return UserDetailsImpl.init(user, rolesForUser);
    }

}
