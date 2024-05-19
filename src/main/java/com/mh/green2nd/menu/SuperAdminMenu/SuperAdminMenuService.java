package com.mh.green2nd.menu.SuperAdminMenu;

import com.mh.green2nd.menu.Menu;
import com.mh.green2nd.menu.MenuRepository;
import com.mh.green2nd.user.Role;
import com.mh.green2nd.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SuperAdminMenuService {

    private final MenuRepository menuRepository;

    public Menu createMenu(User user, Menu menu) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can create menus");
        }
        return menuRepository.save(menu);
    }

    public Menu updateMenu(User user, Menu menu) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can update menus");
        }
        return menuRepository.save(menu);
    }

    public void deleteMenu(User user, Long menuId) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can delete menus");
        }
        menuRepository.deleteById(menuId);
    }
}