package com.mh.green2nd.menu.AdminMenu;

import com.mh.green2nd.menu.Menu;
import com.mh.green2nd.menu.MenuDto;
import com.mh.green2nd.menu.MenuRepository;
import com.mh.green2nd.user.Role;
import com.mh.green2nd.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminMenuService {

    private final MenuRepository menuRepository;

    // admin can update menu
    public Menu updateMenu(User user, Menu menu) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can update menus");
        }
        return menuRepository.save(menu);
    }

    // admin can update menu status
    public Menu updateMenuStatus(User user, Long menuId, boolean status) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can update menu status");
        }
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new RuntimeException("Menu not found"));
        menu.setStatus(status);
        return menuRepository.save(menu);
    }

    // New method to update menu using MenuDto
    public Menu updateMenu(User user, MenuDto menuDto) {
        Menu menu = new Menu();
        // Copy properties from menuDto to menu
        BeanUtils.copyProperties(menuDto, menu);
        return updateMenu(user, menu);
    }
}