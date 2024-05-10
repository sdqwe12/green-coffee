package com.mh.green2nd.menu;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuDto {

    private Long menu_id;

    private String category;

    private String name;

    private String menu_ename;

    private String menu_explain;

    private String menu_origin;

    private String menu_imgurl;
    private String menu_bannerimgurl;

    private double menu_price;
}
