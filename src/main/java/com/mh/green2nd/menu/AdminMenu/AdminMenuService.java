package com.mh.green2nd.menu.AdminMenu;

import com.mh.green2nd.menu.Menu;
import com.mh.green2nd.menu.MenuDto;
import com.mh.green2nd.menu.MenuRepository;
import com.mh.green2nd.user.Role;
import com.mh.green2nd.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminMenuService {

    private final MenuRepository menuRepository;

    //superadmin만 새로운 메뉴 생성 가능
    public Menu createMenu(User user, MenuDto menuDto) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can create menus");
        }
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuDto, menu);
        return menuRepository.save(menu);
    }

    //superadmin만 메뉴 삭제 가능
    public void deleteMenu(User user, Long menuId) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can delete menus");
        }
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new RuntimeException("Menu not found"));
        menuRepository.delete(menu);
    }

    //superadmin과 admin 모두 메뉴 이름 수정 가능
    public Menu updateMenu(User user, Long menuId, String name) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can update menu names");
        }
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new RuntimeException("Menu not found"));
        menu.setName(name);
        return menuRepository.save(menu);
    }

    //superadmin만 메뉴 가격 수정 가능
    public Menu updateMenuPrice(User user, Long menuId, double price) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can update menu prices");
        }
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new RuntimeException("Menu not found"));
        menu.setMenu_price(price);
        return menuRepository.save(menu);
    }

    //superadmin만 메뉴 설명 수정 가능
    public Menu updateMenuExplain(User user, Long menuId, String explain) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can update menu explains");
        }
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new RuntimeException("Menu not found"));
        menu.setMenu_explain(explain);
        return menuRepository.save(menu);
    }

    //superadmin만 메뉴 이미지 수정 가능
    public Menu updateMenuImgUrl(User user, Long menuId, String imgUrl) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can update menu img urls");
        }
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new RuntimeException("Menu not found"));
        menu.setMenu_imgurl(imgUrl);
        return menuRepository.save(menu);
    }

    //superadmin만 메뉴 배너이미지 수정 가능
    public Menu updateMenuBannerImgUrl(User user, Long menuId, String bannerImgUrl) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can update menu banner img urls");
        }
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new RuntimeException("Menu not found"));
        menu.setMenu_bannerimgurl(bannerImgUrl);
        return menuRepository.save(menu);
    }

    //superadmin만 메뉴 영문명 수정 가능
    public Menu updateMenuEname(User user, Long menuId, String ename) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can update menu enames");
        }
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new RuntimeException("Menu not found"));
        menu.setMenu_ename(ename);
        return menuRepository.save(menu);
    }

    //superadmin만 메뉴 카테고리 수정 가능
    public Menu updateMenuCategory(User user, Long menuId, String category) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can update menu categories");
        }
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new RuntimeException("Menu not found"));
        menu.setCategory(category);
        return menuRepository.save(menu);
    }

    // admin만 메뉴 상태 수정 가능
    public Menu updateMenuStatus(User user, Long menuId, boolean status) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can update menu status");
        }
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new RuntimeException("Menu not found"));
        menu.setStatus(status);
        return menuRepository.save(menu);
    }

    // superadmin만 메뉴 숨김 가능
    public Menu updateMenuVisible(User user, Long menuId, boolean visible) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can hide menus");
        }
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new RuntimeException("Menu not found"));
        menu.setVisible(visible);
        return menuRepository.save(menu);
    }

}