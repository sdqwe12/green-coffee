package com.mh.green2nd.exception;

import lombok.Getter;

@Getter
public class JwtGreenException extends RuntimeException{

    private ErrorCode errorCode;

    public JwtGreenException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
