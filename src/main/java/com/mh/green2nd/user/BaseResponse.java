package com.mh.green2nd.user;

public class BaseResponse<T> {
    private T data;
    private String message;
    private int status;

    public BaseResponse(T authCode) {
    }

    // getters and setters
}
