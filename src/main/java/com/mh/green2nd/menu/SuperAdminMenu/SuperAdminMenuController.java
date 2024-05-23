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

    //superadmin만 메뉴 이름 수정 가능
    @Operation(summary = "메뉴 이름 수정", description = "superadmin만 메뉴 이름 수정 가능")
    @PutMapping("/{menuId}/updateName")
    public  ResponseEntity<String> updateMenu(Authentication authentication, @PathVariable Long menuId, @RequestBody String name) {
        User jwtuser = (User) authentication.getPrincipal();
        superAdminMenuService.updateMenu(jwtuser, menuId, name);
        return ResponseEntity.ok("메뉴이름이 수정되었습니다.");
    }

    //superadmin만 메뉴 가격 수정 가능
    @Operation(summary = "메뉴 가격 수정", description = "superadmin만 메뉴 가격 수정 가능")
    @PutMapping("/{menuId}/updatePrice")
    public  ResponseEntity<String> updateMenuPrice(Authentication authentication, @PathVariable Long menuId, @RequestBody double price) {
        User jwtuser = (User) authentication.getPrincipal();
        superAdminMenuService.updateMenuPrice(jwtuser, menuId, price);
        return ResponseEntity.ok("메뉴가격이 수정되었습니다.");
    }

    //superadmin만 메뉴 설명 수정 가능
    @Operation(summary = "메뉴 설명 수정", description = "superadmin만 메뉴 설명 수정 가능")
    @PutMapping("/{menuId}/updateExplain")
    public  ResponseEntity<String> updateMenuExplain(Authentication authentication, @PathVariable Long menuId, @RequestBody String explain) {
        User jwtuser = (User) authentication.getPrincipal();
        superAdminMenuService.updateMenuExplain(jwtuser, menuId, explain);
        return ResponseEntity.ok("메뉴설명이 수정되었습니다.");
    }

    //superadmin만 메뉴 이미지 수정 가능
    @Operation(summary = "메뉴 이미지 수정", description = "superadmin만 메뉴 이미지 수정 가능")
    @PutMapping("/{menuId}/updateImgurl")
    public  ResponseEntity<String> updateMenuImgurl(Authentication authentication, @PathVariable Long menuId, @RequestBody String imgurl) {
        User jwtuser = (User) authentication.getPrincipal();
        superAdminMenuService.updateMenuImgUrl(jwtuser, menuId, imgurl);
        return ResponseEntity.ok("메뉴이미지가 수정되었습니다.");
    }

    //superadmin만 메뉴 영문명 수정 가능
    @Operation(summary = "메뉴 영문명 수정", description = "superadmin만 메뉴 영문명 수정 가능")
    @PutMapping("/{menuId}/updateEname")
    public  ResponseEntity<String> updateMenuEname(Authentication authentication, @PathVariable Long menuId, @RequestBody String ename) {
        User jwtuser = (User) authentication.getPrincipal();
        superAdminMenuService.updateMenuEname(jwtuser, menuId, ename);
        return ResponseEntity.ok("메뉴영문명이 수정되었습니다.");
    }

    //superadmin만 메뉴 카테고리 수정 가능
    @Operation(summary = "메뉴 카테고리 수정 (1 : coffee, 2 : beverage, 3 : food, 4 : goods)", description = "superadmin만 메뉴 카테고리 수정 가능")
    @PutMapping("/{menuId}/updateCategory")
    public  ResponseEntity<String> updateMenuCategory(Authentication authentication, @PathVariable Long menuId, @RequestBody String category) {
        User jwtuser = (User) authentication.getPrincipal();
        superAdminMenuService.updateMenuCategory(jwtuser, menuId, category);
        return ResponseEntity.ok("메뉴카테고리가 수정되었습니다.");
    }

    //superadmin만 visibile 상태 수정 가능
    @Operation(summary = "메뉴 노출 여부 수정", description = "superadmin만 visibile 상태 수정 가능")
    @PutMapping("/{menuId}/updateVisible")
    public  ResponseEntity<String> updateMenuVisible(Authentication authentication, @PathVariable Long menuId, @RequestBody boolean visible) {
        User jwtuser = (User) authentication.getPrincipal();
        superAdminMenuService.updateMenuVisible(jwtuser, menuId, visible);
        return ResponseEntity.ok("메뉴노출여부가 수정되었습니다.");
    }


}
