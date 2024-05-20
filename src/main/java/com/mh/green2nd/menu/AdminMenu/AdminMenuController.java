package com.mh.green2nd.menu.AdminMenu;

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
@RequestMapping("/admin/menu")
public class AdminMenuController {

    private final AdminMenuService adminMenuService;

    // admin can update menu
    @Operation(summary = "메뉴 수정")
    @PutMapping("/update")
    public ResponseEntity<String> updateMenu(Authentication authentication, @RequestBody MenuDto menuDto) {
        User jwtuser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        adminMenuService.updateMenu((User) authentication.getPrincipal(), menuDto);
        return ResponseEntity.ok("메뉴가 수정되었습니다.");
    }

    // admin can update menu status
    @Operation(summary = "메뉴 상태 수정")
    @PutMapping("/{menuId}/status")
    public  ResponseEntity<String> updateMenuStatus(Authentication authentication, @PathVariable Long menuId, @RequestBody boolean status) {
        User jwtuser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        adminMenuService.updateMenuStatus((User) authentication.getPrincipal(), menuId, status);
        return ResponseEntity.ok("메뉴 상태가 수정되었습니다.");
    }

}