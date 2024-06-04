package com.mh.green2nd.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginDto {
    @Schema(description = "이메일", example = "ccc@naver.com")
    private String email;
    @Schema(description = "비밀번호", example = "abc123!")
    private String password;
}
