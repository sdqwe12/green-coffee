package com.mh.green2nd.menu.SuperAdminMenu;

import com.mh.green2nd.menu.MenuDto;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/superadmin/menu")
public class SuperAdminMenuController {

    private final SuperAdminMenuService superAdminMenuService;

    //superadmin만 새로운 메뉴 생성 가능
    @Operation(summary = "메뉴 생성", description = "superadmin만 새로운 메뉴 생성 가능")
    @PostMapping("/create")
    public ResponseEntity<String> createMenu(Authentication authentication, @RequestBody MenuDto menuDto) {
        User jwtuser = (User) authentication.getPrincipal();
        superAdminMenuService.createMenu(jwtuser, menuDto);
        return ResponseEntity.ok("새로운 메뉴가 생성되었습니다.");
    }

    //superadmin만 메뉴 삭제 가능
    @Operation(summary = "메뉴 삭제", description = "superadmin만 메뉴 삭제 가능")
    @DeleteMapping("/{menuId}/delete")
    public ResponseEntity<String> deleteMenu(Authentication authentication, @PathVariable Long menuId) {
        User jwtuser = (User) authentication.getPrincipal();
        superAdminMenuService.deleteMenu(jwtuser, menuId);
        return ResponseEntity.ok("메뉴가 삭제되었습니다.");
    }

    //superadmin만 메뉴 수정 가능
    @Operation(summary = "메뉴 수정", description = "superadmin만 메뉴 수정 가능")
    @PatchMapping("/{menuId}/update")
    public ResponseEntity<String> updateMenu(Authentication authentication, @PathVariable Long menuId, @RequestBody SuperAdminMenuUpdateDto superAdminMenuUpdateDto) {
        User jwtuser = (User) authentication.getPrincipal();
        superAdminMenuService.updateMenu(jwtuser, menuId, superAdminMenuUpdateDto);
        return ResponseEntity.ok("메뉴 정보가 수정되었습니다.");
    }


}
