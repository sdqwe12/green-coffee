package com.mh.green2nd.store;

import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/superadmin/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    //superadmin만 새로운 매장 생성 가능
    @Operation(summary = "새로운 매장 생성", description = "superadmin만 새로운 매장 생성 가능")
    @PostMapping("/create")
    public ResponseEntity<String> createStore(@RequestBody StoreDto storeDto, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        storeService.createStore(currentUser, storeDto);
        return ResponseEntity.ok("새로운 매장이 생성되었습니다.");
    }

    //superadmin만 매장 이름 수정 가능
    @Operation(summary = "매장 이름 수정", description = "superadmin만 매장 이름 수정 가능")
    @PutMapping("/{storeId}/name")
    public ResponseEntity<String> updateStoreName(@PathVariable Long storeId, @RequestBody String name, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        storeService.updateStoreName(currentUser, storeId, name);
        return ResponseEntity.ok("매장 이름이 수정되었습니다.");
    }

    //superadmin과 admin 모두 매장 주소 수정 가능
    @Operation(summary = "매장 주소 수정", description = "superadmin과 admin 모두 매장 주소 수정 가능")
    @PutMapping("/{storeId}/address")
    public  ResponseEntity<String> updateStoreAddress(@PathVariable Long storeId, @RequestBody String address, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        storeService.updateStoreAddress(currentUser, storeId, address);
        return ResponseEntity.ok("매장 주소가 수정되었습니다.");
    }

    //superadmin과 admin 모두 매장 전화번호 수정 가능
    @Operation(summary = "매장 전화번호 수정", description = "superadmin과 admin 모두 매장 전화번호 수정 가능")
    @PutMapping("/{storeId}/phone")
    public  ResponseEntity<String> updateStorePhoneNumber(@PathVariable Long storeId, @RequestBody String phoneNumber, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        storeService.updateStorePhoneNumber(currentUser, storeId, phoneNumber);
        return ResponseEntity.ok("매장 전화번호가 수정되었습니다.");
    }

    // admin만 매장 영업시간 수정 가능
    @Operation(summary = "매장 영업시간 수정", description = "admin만 매장 영업시간 수정 가능")
    @PutMapping("/{storeId}/time")
    public ResponseEntity<String> updateStoreTime(@PathVariable Long storeId, @RequestBody StoreDto storeDto, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        storeService.updateStoreTime(currentUser, storeId, storeDto);
        return ResponseEntity.ok("매장 영업시간이 수정되었습니다.");
    }

    // admin만 휴무일 수정 가능
    @Operation(summary = "매장 휴무일 수정", description = "admin만 휴무일 수정 가능")
    @PutMapping("/{storeId}/holiday")
    public ResponseEntity<String> updateStoreHoliday(@PathVariable Long storeId, @RequestBody String holiday, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        storeService.updateStoreHoliday(currentUser, storeId, holiday);
        return ResponseEntity.ok("매장 휴무일이 수정되었습니다.");
    }
}