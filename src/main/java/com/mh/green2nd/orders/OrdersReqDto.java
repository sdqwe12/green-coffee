package com.mh.green2nd.orders;

import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public class OrdersReqDto {

    private Long id;
    private User user;
    private LocalDateTime paymentTime;
    private LocalDateTime updateTime;
}
