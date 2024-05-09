package com.mh.green2nd.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetail {
    private Long orderId;
    private String customerName;
    private String orderStatus;
    private double totalAmount;

    // getters and setters
}