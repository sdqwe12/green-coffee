package com.mh.green2nd.menu.AdminMenu;

import com.mh.green2nd.menu.MenuDto;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menuChange")
public class AdminMenuController {

    private final AdminMenuService adminMenuService;

    //superadmin만 새로운 메뉴 생성 가능
    @Operation(summary = "메뉴 생성", description = "superadmin만 새로운 메뉴 생성 가능")
    @PostMapping("/create")
    public ResponseEntity<String> createMenu(Authentication authentication, @RequestBody MenuDto menuDto) {
        User jwtuser = (User) authentication.getPrincipal();
        adminMenuService.createMenu(jwtuser, menuDto);
        return ResponseEntity.ok("새로운 메뉴가 생성되었습니다.");
    }

    //superadmin만 메뉴 삭제 가능
    @Operation(summary = "메뉴 삭제", description = "superadmin만 메뉴 삭제 가능")
    @DeleteMapping("/{menuId}/delete")
    public ResponseEntity<String> deleteMenu(Authentication authentication, @PathVariable Long menuId) {
        User jwtuser = (User) authentication.getPrincipal();
        adminMenuService.deleteMenu(jwtuser, menuId);
        return ResponseEntity.ok("메뉴가 삭제되었습니다.");
    }

    //superadmin만 메뉴 이름 수정 가능
    @Operation(summary = "메뉴 이름 수정", description = "superadmin만 메뉴 이름 수정 가능")
    @PutMapping("/{menuId}/updateName")
    public  ResponseEntity<String> updateMenu(Authentication authentication, @PathVariable Long menuId, @RequestBody String name) {
        User jwtuser = (User) authentication.getPrincipal();
        adminMenuService.updateMenu(jwtuser, menuId, name);
        return ResponseEntity.ok("메뉴이름이 수정되었습니다.");
    }

    //superadmin만 메뉴 가격 수정 가능
    @Operation(summary = "메뉴 가격 수정", description = "superadmin만 메뉴 가격 수정 가능")
    @PutMapping("/{menuId}/updatePrice")
    public  ResponseEntity<String> updateMenuPrice(Authentication authentication, @PathVariable Long menuId, @RequestBody double price) {
        User jwtuser = (User) authentication.getPrincipal();
        adminMenuService.updateMenuPrice(jwtuser, menuId, price);
        return ResponseEntity.ok("메뉴가격이 수정되었습니다.");
    }

    //superadmin만 메뉴 설명 수정 가능
    @Operation(summary = "메뉴 설명 수정", description = "superadmin만 메뉴 설명 수정 가능")
    @PutMapping("/{menuId}/updateExplain")
    public  ResponseEntity<String> updateMenuExplain(Authentication authentication, @PathVariable Long menuId, @RequestBody String explain) {
        User jwtuser = (User) authentication.getPrincipal();
        adminMenuService.updateMenuExplain(jwtuser, menuId, explain);
        return ResponseEntity.ok("메뉴설명이 수정되었습니다.");
    }

    //superadmin만 메뉴 이미지 수정 가능
    @Operation(summary = "메뉴 이미지 수정", description = "superadmin만 메뉴 이미지 수정 가능")
    @PutMapping("/{menuId}/updateImgurl")
    public  ResponseEntity<String> updateMenuImgurl(Authentication authentication, @PathVariable Long menuId, @RequestBody String imgurl) {
        User jwtuser = (User) authentication.getPrincipal();
        adminMenuService.updateMenuImgUrl(jwtuser, menuId, imgurl);
        return ResponseEntity.ok("메뉴이미지가 수정되었습니다.");
    }

    //superadmin만 메뉴 배너이미지 수정 가능
    @Operation(summary = "메뉴 배너이미지 수정", description = "superadmin만 메뉴 배너이미지 수정 가능")
    @PutMapping("/{menuId}/updateBannerImgurl")
    public  ResponseEntity<String> updateMenuBannerImgurl(Authentication authentication, @PathVariable Long menuId, @RequestBody String bannerImgurl) {
        User jwtuser = (User) authentication.getPrincipal();
        adminMenuService.updateMenuBannerImgUrl(jwtuser, menuId, bannerImgurl);
        return ResponseEntity.ok("메뉴배너이미지가 수정되었습니다.");
    }

    //superadmin만 메뉴 영문명 수정 가능
    @Operation(summary = "메뉴 영문명 수정", description = "superadmin만 메뉴 영문명 수정 가능")
    @PutMapping("/{menuId}/updateEname")
    public  ResponseEntity<String> updateMenuEname(Authentication authentication, @PathVariable Long menuId, @RequestBody String ename) {
        User jwtuser = (User) authentication.getPrincipal();
        adminMenuService.updateMenuEname(jwtuser, menuId, ename);
        return ResponseEntity.ok("메뉴영문명이 수정되었습니다.");
    }

    //superadmin만 메뉴 카테고리 수정 가능
    @Operation(summary = "메뉴 카테고리 수정 (1 : coffee, 2 : beverage, 3 : food, 4 : goods)", description = "superadmin만 메뉴 카테고리 수정 가능")
    @PutMapping("/{menuId}/updateCategory")
    public  ResponseEntity<String> updateMenuCategory(Authentication authentication, @PathVariable Long menuId, @RequestBody String category) {
        User jwtuser = (User) authentication.getPrincipal();
        adminMenuService.updateMenuCategory(jwtuser, menuId, category);
        return ResponseEntity.ok("메뉴카테고리가 수정되었습니다.");
    }

    // admin만 메뉴 상태 수정 가능
    @Operation(summary = "메뉴 상태 수정", description = "0: 품절, 1: 판매중")
    @PutMapping("/{menuId}/status")
    public  ResponseEntity<String> updateMenuStatus(Authentication authentication, @PathVariable Long menuId, @RequestBody boolean status) {
        User jwtuser = (User) authentication.getPrincipal();
        adminMenuService.updateMenuStatus(jwtuser, menuId, status);
        return ResponseEntity.ok("메뉴 상태가 수정되었습니다.");
    }


}
