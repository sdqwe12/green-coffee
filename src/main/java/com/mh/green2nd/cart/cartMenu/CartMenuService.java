package com.mh.green2nd.cart.cartMenu;

import com.mh.green2nd.cart.Cart;
import com.mh.green2nd.menu.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartMenuService {

    private final CartMenuRepository cartMenuRepository;

    public CartMenu createCartMenu(Cart cart, Menu menu, int quantity) {
        CartMenu cartMenu = new CartMenu();
        cartMenu.setCart(cart);
        cartMenu.setMenu(menu);
        cartMenu.setQuantity(quantity);
        return cartMenuRepository.save(cartMenu);
    }

    public double calculateSubCartPrice(CartMenu cartMenu) {
        Menu menu = cartMenu.getMenu();
        int quantity = cartMenu.getQuantity();
        int ice = cartMenu.getIce();
        int shot = cartMenu.getShot();
        int cream = cartMenu.getCream();
        int price_ice = menu.getPrice_ice();
        int price_shot = menu.getPrice_shot();
        int price_cream = menu.getPrice_cream();

        double menuPrice = menu.getMenu_price();
        int optionPrice = price_ice * ice + price_shot * shot + price_cream * cream;
        return (menuPrice + optionPrice) * quantity;
    }

}
