package com.mh.green2nd.exception;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter

public enum ErrorCode {

    //로그인
    LOGINFAILED1(HttpStatus.UNAUTHORIZED,"lOGINFAILED1","이메일과 패스워드를 확인하세요."),
    LOGINFAILED2(HttpStatus.UNAUTHORIZED,"lOGINFAILED2","이미 탈퇴한 회원입니다."),
    //패스워드체크
    PWCHECKFAILED(HttpStatus.UNAUTHORIZED,"PWCHECKFAILED","비밀번호가 일치하지 않습니다."),
    //회원가입
    DUPLICATEEMAIL(HttpStatus.UNAUTHORIZED,"DUPLICATEEMAIL","중복되는 이메일이 있습니다."),
    DUPLICATENICKNAME(HttpStatus.UNAUTHORIZED,"DUPLICATENICKNAME","중복되는 닉네임이 있습니다."),
    DUPLICATEPHONE(HttpStatus.UNAUTHORIZED,"DUPLICATEPHONE","중복되는 휴대폰번호가 있습니다."),
    //찾기
    NOTFOUNDPHONE(HttpStatus.UNAUTHORIZED,"NOTFOUNDPHONE","해당 핸드폰번호를 가진 회원이 없습니다."),

    DUPLICATE(HttpStatus.BAD_REQUEST,"DUPLICATE","중복된 내용이 있습니다."),
    NOTFOUND(HttpStatus.NOT_FOUND,"NOTFOUND","해당해는 내용이없습니다."),
    TEST(HttpStatus.BAD_GATEWAY,"TEST","TEST입니다."),
    NOTUPDATEEMAIL(HttpStatus.NOT_FOUND,"NOTUPDATE","수정할이메일이없습니다."),

    ;

    private HttpStatus httpStatus;
    private String errorCode;
    private String message;

    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }



}

