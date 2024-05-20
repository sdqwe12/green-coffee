package com.mh.green2nd.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    //300 없는 권한
    UNAUTHORIZED(300, "권한이 없습니다."),

    //400 BAD_REQUEST 잘못된 요청
    INVALID_PARAMETER(400, "파라미터 값을 확인해주세요."),

    //404 NOT_FOUND 잘못된 리소스 접근
    NOT_FOUND(404, "존재하지 않습니다"),
    NOT_SAVED(404, "저장하지 않았습니다."),

    //409 CONFLICT 중복된 리소스
    ALREADY_SAVED(409, "이미 저장하였습니다."),

    //500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(500, "서버 에러입니다.");

    private final int status;
    private final String message;
}