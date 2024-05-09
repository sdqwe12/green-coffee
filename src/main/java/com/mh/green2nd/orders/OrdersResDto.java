package com.mh.green2nd.orders;

import com.mh.green2nd.user.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrdersResDto {
    private Long id;
    private User user;
    private LocalDateTime paymentTime;
    private LocalDateTime updateTime;
}
