package com.mh.green2nd.cart.cartMenu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mh.green2nd.cart.Cart;
import com.mh.green2nd.menu.Menu;
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
@Table(name = "cart_menu")
public class CartMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartmenu_id", nullable = false)
    private Long cartmenu_id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    private int quantity;
    private int ice;
    private int shot;
    private int cream;

}