package com.mh.green2nd.menu.SuperAdminMenu;

import com.mh.green2nd.menu.Menu;
import com.mh.green2nd.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/superadmin/menu")
public class SuperAdminMenuController {

    private final SuperAdminMenuService superAdminMenuService;

     @PostMapping("/create")
     public Menu createMenu(@AuthenticationPrincipal User user, @RequestBody Menu menu) {
         return superAdminMenuService.createMenu(user, menu);
     }

     @PostMapping("/update")
     public Menu updateMenu(@AuthenticationPrincipal User user, @RequestBody Menu menu) {
         return superAdminMenuService.updateMenu(user, menu);
     }

     @PostMapping("/delete")
     public void deleteMenu(@AuthenticationPrincipal User user, @RequestParam Long menuId) {
         superAdminMenuService.deleteMenu(user, menuId);
     }

}
