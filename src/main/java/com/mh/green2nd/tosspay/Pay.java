package com.mh.green2nd.tosspay;

import com.mh.green2nd.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pay_id")
    private Long id;

    @Column(nullable = false)
    private Long amount;
    @Column(nullable = false)
    private String orderId;
    @Column(nullable = false)
    private String ID;
    @Column(nullable = false)
    private String customerName;
    @Column(nullable = false)
    private LocalDateTime createDate;
    @Column(nullable = false)
    private String paySuccessYn;

    @Column
    @Setter
    private String paymentKey;

    @Column
    private String payFailReason;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public PayRes toRes() {
        return PayRes.builder()
                .amount(amount)
                .orderId(orderId)
                .ID(ID)
                .customerName(customerName)
                .createDate(createDate)
                .paySuccessYn(paySuccessYn.equals("Y"))
                .build();
    }
}
