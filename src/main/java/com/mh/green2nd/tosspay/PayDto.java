package com.mh.green2nd.tosspay;

import com.mh.green2nd.user.User;
import lombok.Data;

@Data
public class PayDto {

    private String orderId;
    private String orderName;
    private String requestedAt;
    private String approvedAt;
    private int totalAmount;

    private User user;


}
