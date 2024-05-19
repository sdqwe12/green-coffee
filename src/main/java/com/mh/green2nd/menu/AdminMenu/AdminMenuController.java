package com.mh.green2nd.menu.AdminMenu;

import com.mh.green2nd.menu.Menu;
import com.mh.green2nd.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/menu")
public class AdminMenuController {

    private final AdminMenuService adminMenuService;

    // admin can update menu
     @PostMapping("/update")
     public Menu updateMenu(@AuthenticationPrincipal User user, @RequestBody Menu menu) {
         return adminMenuService.updateMenu(user, menu);
     }

     // admin can update menu status
    @PutMapping("/{menuId}/status")
    public Menu updateMenuStatus(@AuthenticationPrincipal User user, @PathVariable Long menuId, @RequestBody boolean status) {
        return adminMenuService.updateMenuStatus(user, menuId, status);
    }

}
