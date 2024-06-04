package com.mh.green2nd.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FindPwDto {
    @Schema(description = "전화번호", example = "010-1111-1111")
    private String phone;
}