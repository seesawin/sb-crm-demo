package com.demo.controller;


import com.demo.bean.so.user.LoginSO;
import com.demo.bean.so.user.SignupSO;
import com.demo.bean.vo.CommonVO;
import com.demo.bean.vo.LoginVO;
import com.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    @ApiOperation("user register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupSO signupSO) throws Exception {
        userService.register(signupSO);
        return ResponseEntity.ok(CommonVO.success());
    }

    @PostMapping("/login")
    @ApiOperation(
            value = "login",
            notes = "use this api to get the token and store in localstorage. Remove the token after user logout",
            response = LoginVO.class)
    public ResponseEntity<?> login(@Valid @RequestBody LoginSO loginSO) throws Exception {
        return ResponseEntity.ok(CommonVO.success(userService.login(loginSO)));
    }
}
