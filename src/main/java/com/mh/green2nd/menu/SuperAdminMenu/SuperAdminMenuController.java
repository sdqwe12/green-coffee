package com.mh.green2nd.menu.SuperAdminMenu;

import com.mh.green2nd.menu.Menu;
import com.mh.green2nd.menu.MenuDto;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/superadmin/menu")
public class SuperAdminMenuController {

    private final SuperAdminMenuService superAdminMenuService;

    @Operation(summary = "메뉴 생성")
     @PostMapping("/create")
     public ResponseEntity<String> createMenu(Authentication authentication, @RequestBody Menu menu) {
        User jwtuser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        superAdminMenuService.createMenu((User) authentication.getPrincipal(), menu);
    return ResponseEntity.ok("메뉴가 생성되었습니다.");
    }

    @Operation(summary = "메뉴 수정")
    @PutMapping("/update")
    public  ResponseEntity<String> updateMenu(Authentication authentication, @RequestBody Menu menu) {
        User jwtuser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        superAdminMenuService.updateMenu((User) authentication.getPrincipal(), menu);
        return ResponseEntity.ok("메뉴가 수정되었습니다.");
    }

    @Operation(summary = "메뉴 삭제")
     @PostMapping("/delete")
     public  ResponseEntity<String> deleteMenu(Authentication authentication, @RequestBody Long menuId) {
            User jwtuser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            superAdminMenuService.deleteMenu((User) authentication.getPrincipal(), menuId);
            return ResponseEntity.ok("메뉴가 삭제되었습니다.");
     }

}
