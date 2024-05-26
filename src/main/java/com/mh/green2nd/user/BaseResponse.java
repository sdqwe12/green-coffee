package com.mh.green2nd.user;

import lombok.Data;

@Data
public class BaseResponse<T> {
    private T data;
    private String message;
    private int status;

    public BaseResponse(T authCode) {
    }

    // getters and setters
}
