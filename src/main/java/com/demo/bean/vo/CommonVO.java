package com.demo.bean.vo;

import lombok.Data;

@Data
public class CommonVO<T> {
    private static String SUCCESS = "success";
    private static String FAIL = "fail";
    private static String SUCCESS_CODE = "00";
    private static String FAIL_CODE = "01";
    String code;
    String msg;
    T data;

    public static CommonVO success() {
        CommonVO response = new CommonVO();
        response.setCode(SUCCESS_CODE);
        response.setMsg(SUCCESS);
        return response;
    }

    public static <T> CommonVO success(T data) {
        CommonVO response = new CommonVO();
        response.setCode(SUCCESS_CODE);
        response.setMsg(SUCCESS);
        response.setData(data);
        return response;
    }

    public static CommonVO fail(String msg) {
        CommonVO response = new CommonVO();
        response.setCode(FAIL_CODE);
        response.setMsg(msg);
        return response;
    }
}
