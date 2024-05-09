package com.mh.green2nd.orders;

import com.mh.green2nd.orders.ordersItem.OrdersItem;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "orders")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrdersItem> items = new ArrayList<>();

    @CreatedDate
    @Schema(title = "결제시간")
    private LocalDateTime paymentTime;

    @LastModifiedDate
    @Schema(title = "수정시간")
    private LocalDateTime updateTime;
}
