package com.mh.green2nd.custom;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomReqDto {
    private Long menuId;
    @Column(nullable = false, length = 20)
    private String myname;
    private int size;
    private int ice;
    private int shot;
    private int cream;

}
