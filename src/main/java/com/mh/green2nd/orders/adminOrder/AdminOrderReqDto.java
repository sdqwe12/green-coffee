package com.mh.green2nd.orders.adminOrder;

import lombok.Data;

@Data
public class AdminOrderReqDto {

        private String name;
        private String address;
        private String phone;
        private String open;
        private String close;
        private String holiday;
        private String status;
}
