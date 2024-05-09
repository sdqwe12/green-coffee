package com.mh.green2nd.orders.ordersItem;

import com.mh.green2nd.cart.cartMenu.CartMenu;
import com.mh.green2nd.orders.Orders;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "ordersitem")
public class OrdersItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordersitemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @OneToOne
    @JoinColumn(name = "cartmenu_id")
    private CartMenu cartMenu;
}
