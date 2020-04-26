package com.user.userinfo.dto;

import lombok.Data;


@Data
public class ApiResponse {
    private String message;
    private Object result;

    public ApiResponse(String message, Object result){
        this.message = message;
        this.result = result;
    }
}