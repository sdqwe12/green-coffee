package com.mh.green2nd.store.AdminStore;

import com.mh.green2nd.store.Store;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/store")
@RequiredArgsConstructor
public class AdminStoreController {

    private final AdminStoreService adminStoreService;

    @Operation(summary = "매장 정보 수정")
    @PutMapping("/{storeId}/status")
    public ResponseEntity<String> updateStoreStatus(@PathVariable Long storeId, @RequestBody String status, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        adminStoreService.updateStoreStatus(currentUser, storeId, status);
        return ResponseEntity.ok("매장 상태가 수정되었습니다.");
    }

    @Operation(summary = "매장 주소 수정")
    @PutMapping("/{storeId}/address")
    public  ResponseEntity<String> updateStoreAddress(@PathVariable Long storeId, @RequestBody String address, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        adminStoreService.updateStoreAddress(currentUser, storeId, address);
        return ResponseEntity.ok("매장 주소가 수정되었습니다.");
    }

    @Operation(summary = "매장 전화번호 수정")
    @PutMapping("/{storeId}/phone")
    public  ResponseEntity<String> updateStorePhoneNumber(@PathVariable Long storeId, @RequestBody String phoneNumber, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        adminStoreService.updateStorePhoneNumber(currentUser, storeId, phoneNumber);
        return ResponseEntity.ok("매장 전화번호가 수정되었습니다.");
    }

    @Operation(summary = "매장 휴무일 수정")
    @PutMapping("/{storeId}/holiday")
    public  ResponseEntity<String> updateStoreHoliday(@PathVariable Long storeId, @RequestBody String holiday, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        adminStoreService.updateStoreHoliday(currentUser, storeId, holiday);
        return ResponseEntity.ok("매장 휴무일이 수정되었습니다.");
    }

    @Operation(summary = "매장 영업시간 수정")
    @PutMapping("/{storeId}/hours")
    public  ResponseEntity<String> updateStoreOperatingHours(@PathVariable Long storeId, @RequestBody String open, @RequestBody String close, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        adminStoreService.updateStoreOperatingHours(currentUser, storeId, open, close);
        return ResponseEntity.ok("매장 영업시간이 수정되었습니다.");
    }
}