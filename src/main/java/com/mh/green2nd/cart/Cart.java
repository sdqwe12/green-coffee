package com.mh.green2nd.cart;

import com.mh.green2nd.cart.cartMenu.CartMenu;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity

@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", nullable = false)
    private Long cartId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private List<CartMenu> cartMenusList = new ArrayList<>();



    @Column(name = "total_price")
    private double totalPrice;
    public void addToTotalPrice(double price) {
        this.totalPrice += price;
    }
    public void clearItems() {
        this.cartMenusList.clear();
    }



//    @Enumerated(EnumType.STRING)
//    @Schema(title = "얼음 옵션   없음 적게 기본 추가 = i0 i1 i2 i3")
//    private Ice ice;
//    @Enumerated(EnumType.STRING)
//    @Schema(title = "샷 옵션   기본 1샷 2샷 3샷 = s0 s1 s2 s3")
//    private Shot shot;
//    @Enumerated(EnumType.STRING)
//    @Schema(title = "크림 옵션 없음 기본 추가 = c0 c1 c2 c3")
//    private Cream cream;
}
