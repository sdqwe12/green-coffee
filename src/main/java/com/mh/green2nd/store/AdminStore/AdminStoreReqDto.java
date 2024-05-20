package com.mh.green2nd.store.AdminStore;

import lombok.Data;

@Data
public class AdminStoreReqDto {

        private String name;
        private String address;
        private String phone;
        private String open;
        private String close;
        private String holiday;
        private String status;
}
