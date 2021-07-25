package com.demo.bean.vo;

import lombok.Data;

import java.util.List;

@Data
public class LoginVO {
    private Long id;
    private String token;
    private String name;
    private List<String> roles;

    public static LoginVO init(String accessToken, Long id, String username, List<String> roles) {
        LoginVO loginVO = new LoginVO();
        loginVO.setId(id);
        loginVO.setName(username);
        loginVO.setToken(accessToken);
        loginVO.setRoles(roles);
        return loginVO;
    }
}
