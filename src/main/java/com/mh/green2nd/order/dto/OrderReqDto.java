package com.mh.green2nd.order.dto;

import lombok.Data;

@Data
public class OrderReqDto {

    private Long cartmenu_id;
    private int ice;
    private int shot;
    private int cream;
    private int quantity;

}
