package com.mh.green2nd.cart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mh.green2nd.user.Resign;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CartReqDto {

    private Long menuId;
    @Column(columnDefinition = "integer default 1")
    private int quantity;
    private Long cartId;
//    @Enumerated(EnumType.STRING)
//    @Schema(title = "")
//    @JsonIgnore
//    @Builder.Default
//    private Resign resign = Resign.N;

    @Enumerated(EnumType.STRING)
    @Schema(title = "얼음 옵션   없음 적게 기본 추가 = i0 i1 i2 i3")
    @Builder.Default
    private Ice ice = Ice.i0;
    @Enumerated(EnumType.STRING)
    @Schema(title = "샷 옵션   기본 1샷 2샷 3샷 = s0 s1 s2 s3")
    @Builder.Default
    private Shot shot = Shot.s0;
    @Enumerated(EnumType.STRING)
    @Schema(title = "크림 옵션 없음 기본 추가 = c0 c1 c2 c3")
    @Builder.Default
    private Cream cream = Cream.c0;
}
