package com.mh.green2nd.store.superAdminStore;
import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
public class StoreInfo {

    private String name;
    private String address;
    private String phone;
    private String open;
    private String close;
    private String holiday;
    private String status;
    private String admin_name;
    private Map<LocalDate, Double> salesInfo;

    public StoreInfo(String name, String address, String phone, String open, String close, String holiday, String status, String admin_name, Map<LocalDate, Double> salesInfo) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.open = open;
        this.close = close;
        this.holiday = holiday;
        this.status = status;
        this.admin_name = admin_name;
        this.salesInfo = salesInfo;
    }

}