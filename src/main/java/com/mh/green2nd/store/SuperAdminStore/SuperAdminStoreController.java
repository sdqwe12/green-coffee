package com.mh.green2nd.store.SuperAdminStore;

import com.mh.green2nd.store.Store;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/superadmin/store")
@RequiredArgsConstructor
public class SuperAdminStoreController {

    private final SuperAdminStoreService superAdminStoreService;

    @Operation(summary = "매장 이름 수정")
    @PutMapping("/{storeId}/name")
    public ResponseEntity<String> updateStoreName(@PathVariable Long storeId, @RequestBody String name, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        superAdminStoreService.updateStoreName(currentUser, storeId, name);
        return ResponseEntity.ok("매장 이름이 수정되었습니다.");
    }

    @Operation(summary = "매장 상태 수정")
    @PutMapping("/{storeId}/address")
    public  ResponseEntity<String> updateStoreAddress(@PathVariable Long storeId, @RequestBody String address, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        superAdminStoreService.updateStoreAddress(currentUser, storeId, address);
        return ResponseEntity.ok("매장 주소가 수정되었습니다.");
    }

    @Operation(summary = "매장 전화번호 수정")
    @PutMapping("/{storeId}/phone")
    public  ResponseEntity<String> updateStorePhoneNumber(@PathVariable Long storeId, @RequestBody String phoneNumber, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        superAdminStoreService.updateStorePhoneNumber(currentUser, storeId, phoneNumber);
        return ResponseEntity.ok("매장 전화번호가 수정되었습니다.");
    }

}