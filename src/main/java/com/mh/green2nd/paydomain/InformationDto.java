package com.mh.green2nd.paydomain;

import lombok.Data;

@Data
public class InformationDto {

    private String paymentKey;
    private String orderId;
    private int amount;
    private String paymentType;
}
