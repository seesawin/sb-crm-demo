package com.demo.service;

import com.demo.bean.model.Role;
import com.demo.bean.model.User;
import com.demo.bean.model.UserRole;
import com.demo.bean.so.user.LoginSO;
import com.demo.bean.so.user.SignupSO;
import com.demo.bean.vo.LoginVO;
import com.demo.config.security.jwt.JwtUtils;
import com.demo.config.security.services.UserDetailsImpl;
import com.demo.dao.RoleDao;
import com.demo.dao.UserDao;
import com.demo.dao.UserRoleDao;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
    @Resource
    UserDao userDao;
    @Resource
    UserRoleDao userRoleDao;
    @Resource
    RoleDao roleDao;
    @Resource
    PasswordEncoder encoder;
    @Resource
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;

    /**
     * register
     *
     * @param signupSO
     * @throws Exception
     */
    public void register(SignupSO signupSO) throws Exception {
        //validate
        validateRegister(signupSO);
        //create user
        User user = User.init(signupSO.getName(), encoder.encode(signupSO.getPassword()));
        //get user role
        Map<String, Role> roleMap = Maps.uniqueIndex(roleDao.findAll(), Role::getName);
        Role role = roleMap.get(signupSO.getRole());
        //save
        userDao.save(user);
        UserRole userRoles = UserRole.init(user.getId(), role.getId());
        userRoleDao.save(userRoles);
    }

    /**
     * validate user's information
     *
     * @param signupSO
     * @throws Exception
     */
    private void validateRegister(SignupSO signupSO) throws Exception {
        List<User> users = userDao.findAll();
        Optional<User> userOpt = users.stream().filter(it -> it.getName().equals(signupSO.getName())).findFirst();
        if (userOpt.isPresent()) {
            throw new Exception("name is already taken!");
        }
    }

    /**
     * user login
     *
     * @param loginSO
     * @return
     */
    public LoginVO login(LoginSO loginSO) {
        //authenticate user and get roles
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginSO.getName(), loginSO.getPassword()));
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
        //create response vo
        LoginVO loginVO = LoginVO.init(jwtUtils.generateJwtToken(authentication), userDetails.getId(), userDetails.getUsername(), roles);
        return loginVO;
    }
}
